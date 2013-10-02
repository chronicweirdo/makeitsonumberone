package com.chronicweirdo.makeitso.grammar.wiki.text3;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import com.chronicweirdo.makeitso.grammar.Util;
import com.chronicweirdo.makeitso.grammar.wiki.Telement2WikiListenerImpl;
import com.chronicweirdo.makeitso.grammar.wiki.TestWiki;
import com.chronicweirdo.makeitso.grammar.wiki.WikiLexer;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser;

public class Telement {

	private Telement previous;
	private Telement next;
	
	private String name;
	private StringBuffer value;
	
	public Telement(String value) {
		this.value = new StringBuffer(value);
	}
	public Telement(String name, String value) {
		this.name = name;
		this.value = new StringBuffer(value);
	}
	
	public Telement first() {
		Telement first = this;
		while (first.previous != null) first = first.previous;
		return first;
	}
	
	public Telement last() {
		Telement last = this;
		while (last.next != null) last = last.next;
		return last;
	}
	
	
	public static Telement create(String ...strings) {
		return create(null, Arrays.asList(strings));
	}
	
	public int offset() {
		int offset = 0;
		Telement current = this.first();
		while (current != this) {
			offset += current.value.length();
			current = current.next;
		}
		return offset;
	}
	
	public int endOffset() {
		return offset() + value.length();
	}
	
	public static Telement create(List<String> names, List<String> values) {
		if (values.size() == 0) return null;
		Telement first = null;
		Telement current = null;
		for (int i = 0; i < values.size(); i++) {
			Telement n = null;
			if (names != null && i < names.size()) {
				n = new Telement(names.get(i), values.get(i));
			} else {
				n = new Telement(values.get(i));
			}
			if (first == null) {
				first = n;
			} else {
				current.next = n;
				n.previous = current;
			}
			current = n;
		}
		return first;
	}
	
	public void insert(int offset, String string) {
		Telement current = this;
		while (current != null && current.value.length() < offset) {
			offset -= current.value.length();
			current = current.next;
		}
		if (current == null) {
			// insert at the end of the last element
			Telement last = this.last();
			last.value.append(string);
			split(last);
		} else {
			// insert into current
			current.value.insert(offset, string);
			split(current);
		}
	}
	
	// merge into start
	public static void merge(Telement start, Telement end) {
		if (start == null) return;
		if (end == null) end = start.last();
		if (!end.follows(start)) return;
		start.name = null;
		Telement current = start.next;
		while (current != end) {
			start.value.append(current.value);
			current = current.next;
		}
		start.value.append(end.value);
		start.next = end.next;
	}
	
	public static void split(Telement node) {
		// save external links
		Telement before = node.previous;
		Telement after = node.next;
		// parse node data to new Telement
		try {
			Telement2WikiListenerImpl listener = new Telement2WikiListenerImpl();
			Util.test(WikiLexer.class, WikiParser.class,  listener, "page",  node.value.toString());
			Telement page = listener.getPage();
			//Telement page = TestWiki.split(node.value.toString());
			
			// replace node with first element of result
			node.value = page.value;
			node.name = page.name;
			node.next = page.next;
			if (page.next != null) page.next.previous = node;
			// link end of new list to "after"
			Telement nodeLast = node.last();
			nodeLast.next = after;
			if (after != null) after.previous = nodeLast; 
		} catch (Exception e) {
		}
	}
	
	public boolean follows(Telement before) {
		Telement current = this.previous;
		while (current != null) {
			if (current == before) return true;
			current = current.previous;
		}
		return false;
	}
 	
	public void delete(int offset, int length) {
		Telement current = this;
		// find starting point
		while (current != null && current.value.length() < offset) {
			offset -= current.value.length();
			current = current.next;
		}
		Telement start = current;
		int startPosition = offset;
		if (start != null) {
			System.out.println("start: " + start.elementToString() + ", position: " + startPosition);
		} else {
			System.out.println("start: null");
		}
		// find end point
		offset += length;
		while (current != null && current.value.length() < offset) {
			offset -= current.value.length();
			current = current.next;
		}
		Telement end = current;
		int endPosition = offset;
		if (end != null) {
			System.out.println("end: " + end.elementToString() + ", position: " + endPosition);
		} else {
			System.out.println("end: null");
		}
		// merge
		merge(start, end);
		// delete
		start.value.delete(startPosition, startPosition + length);
		// split
		split(start);
	}
	
	public static Telement link(List<Telement> els) {
		Telement first = null;
		Telement current = null;
		for (Telement el: els) {
			if (first == null) {
				first = el;
			} else {
				current.last().next = el;
				el.first().previous = current;
			}
			current = el.last();
		}
		return first;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Telement current = this;
		while (current != null) {
			builder.append(current.value);
			current = current.next;
		}
		return builder.toString();
	}
	
	public String elementToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		if (name != null) {
			builder.append(name).append(", ");
		}
		builder.append(value).append(", ");
		builder.append(offset()).append(", ");
		builder.append(endOffset());
		builder.append(")");
		return builder.toString();
	}
	public void print(StringBuilder builder) { 
		Telement current = this;
		while (current != null) {
			builder.append(current.elementToString()).append("\n");
			current = current.next;
		}
	}
}
