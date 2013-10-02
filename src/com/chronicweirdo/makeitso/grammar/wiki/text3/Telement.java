package com.chronicweirdo.makeitso.grammar.wiki.text3;

import java.util.Arrays;
import java.util.List;

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
			this.last().value.append(string);
		} else {
			// insert into current
			current.value.insert(offset, string);
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
		start.value.delete(startPosition, startPosition + length);
		/*if (start == null) {
			// can't delete
			return;
		} else {
			if (start == end) {
				// we delete only from one node
				start.value.delete(startPosition, endPosition);
				// we check if the node has anything left
				if (start.value.length() == 0) {
					if (start.previous != null) start.previous.next = start.next;
					if (start.next != null) start.next.previous = start.previous;
				}
			} else {
				if (end == null) {
					// delete from start and all nodes afterward
					start.value.delete(startPosition, start.value.length());
					start.next = null;
				} else {
					// delete from start
					start.value.delete(startPosition, start.value.length());
					// delete from end
					end.value.delete(0, endPosition);
					// delete nodes in between
					start.next = end;
					end.previous = start;
				}
			}
		}*/
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
