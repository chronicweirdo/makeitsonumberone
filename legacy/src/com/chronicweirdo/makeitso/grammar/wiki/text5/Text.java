package com.chronicweirdo.makeitso.grammar.wiki.text5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Text {

	private TT first;
	private TT last;
	private List<TG> groups;
	
	public TT first() {
		return first;
	}
	
	public TT last() {
		return last;
	}
	
	public Text() {
		groups = new ArrayList<TG>();
	}
	
	public Text(String token) {
		groups = new ArrayList<TG>();
		first = new TT(token);
		last = first;
	}
	
	// add a token
	public TT add(String text) {
		TT t = new TT(text);
		if (first == null) {
			first = t;
			last = t;
		} else {
			last.append(t);
			last = t;
		}
		return t;
	}
	
	// add new token to group
	public TT add(String text, TG group) {
		TT t = add(text);
		group.add(t);
		return t;
	}
	
	// add a group
	public TG group() {
		TG g = new TG();
		groups.add(g);
		return g;
	}
	
	public Text append(Text t) {
		if (first == null) {
			first = t.first;
			last = t.last;
		} else {
			last.append(t.first);
			last = t.last;
		}
		groups.addAll(t.groups);
		return this;
	}
	
	public void delete(int offset, int length) {
		// find affected nodes
		int startOffset = offset;
		int endOffset = offset + length;
		TT from = first.nodeAt(startOffset);
		TT to = first.nodeAt(endOffset);
		// find affected groups
		Set<TG> groups = findGroups(from, to);
		// find affected nodes
		from = firstFromGroups(groups);
		to = lastFromGroups(groups);
		// merge nodes
		TT.merge(from, to);
		// delete groups
		this.groups.removeAll(groups);
		// execute delete
		TT node = first.nodeAt(startOffset);
		int o = node.offset();
		node.value().delete(startOffset-o, endOffset-o);
		// split node
	}
	
	public TT firstFromGroups(Set<TG> groups) {
		TT first = null;
		for (TG g: groups) {
			TT f = g.first();
			if (first == null) {
				first = f;
			} else {
				if (f.before(first)) {
					first = f;
				}
			}
		}
		return first;
	}
	
	public TT lastFromGroups(Set<TG> groups) {
		TT last = null;
		for (TG g: groups) {
			TT f = g.last();
			if (last == null) {
				last = f;
			} else {
				if (last.before(f)) {
					last = f;
				}
			}
		}
		return last;
	}
	
	public Set<TG> findGroups(TT node) {
		Set<TG> r = new HashSet<TG>();
		for (TG g: groups) {
			if (g.contains(node)) r.add(g);
		}
		return r;
	}
	
	public Set<TG> findGroups(TT from, TT to) {
		Set<TG> r = new HashSet<TG>();
		TT x = from;
		while (x != to) {
			r.addAll(findGroups(x));
			x = x.next();
		}
		r.addAll(findGroups(x));
		return r;
	}
	
	public void print() {
		first.print();
		System.out.println("groups: " + groups.size());
		for (TG g: groups) {
			g.print();
			System.out.println();
		}
	}
	
	public String toString() {
		return first.toString();
	}
}
