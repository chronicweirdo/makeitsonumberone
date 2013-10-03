package com.chronicweirdo.makeitso.grammar.wiki.text5;

public class TT {

	private StringBuffer value;
	private TT previous;
	private TT next;
	
	public TT(String value) {
		this.value = new StringBuffer(value); 
	}
	
	// navigation
	public TT previous() {
		return previous;
	}
	public TT next() {
		return next;
	}
	public TT first() {
		TT x = this;
		while (x.previous != null) x = x.previous;
		return x;
	}
	public TT last() {
		TT x = this;
		while (x.next != null) x = x.next;
		return x;
	}
	
	// linking
	public void previous(TT x) {
		this.previous = x;
	}
	public void next(TT x) {
		this.next = x;
	}
	public void append(TT x) {
		this.next = x;
		x.previous = this;
	}
	
	// ordering
	// check if current node is before x
	public boolean before(TT x) {
		x = x.previous;
		while (x != null) {
			if (x == this) return true;
			x = x.previous;
		}
		return false;
	}
	
	// merging
	public static void merge(TT from, TT to) {
		TT before = from.previous;
		TT after = to.next;
		
		StringBuilder b = new StringBuilder();
		TT x = from;
		while (x != to) {
			b.append(x.value);
			x = x.next;
		}
		b.append(x.value);
		
		TT n = new TT(b.toString());
		if (before != null) before.append(n);
		if (after != null) n.append(after);
	}
	
	public void print() {
		TT x = this;
		while (x != null) {
			/*System.out.print("(");
			if (x.previous != null) {
				System.out.print(x.previous.value);
			} else {
				System.out.print("null");
			}
			System.out.print(" : ");*/
			
			System.out.println(x.value);
			
			/*System.out.print(" : ");
			if (x.next != null) {
				System.out.print(x.next.value);
			} else {
				System.out.print("null");
			}
			System.out.println(")");*/
			x = x.next;
		}
	}
	
	public String toString() {
		return value.toString();
	}
	
	public static void main(String[] args) {
		TT t = new TT("a");
		t.last().append(new TT(" "));
		TT t1 = new TT("fost");
		t.last().append(t1);
		t.last().append(new TT(" "));
		TT t2 = new TT("o");
		t.last().append(t2);
		t.last().append(new TT(" "));
		t.last().append(new TT("data"));
		
		t.print();
		merge(t1, t2);
		t.print();
	}
}
