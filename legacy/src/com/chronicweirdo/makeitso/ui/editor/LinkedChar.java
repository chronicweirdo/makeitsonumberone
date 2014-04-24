package com.chronicweirdo.makeitso.ui.editor;

public class LinkedChar {

	private Character c;
	private LinkedChar prev;
	private LinkedChar next;
	
	public static LinkedChar text(String text) {
		LinkedChar first = null;
		LinkedChar current = null;
		for (int i = 0; i < text.length(); i++) {
			LinkedChar c = new LinkedChar(text.charAt(i));
			if (current != null) {
				current.next = c;
				c.prev = current;
				current = c;
			} else {
				current = c;
				first = current;
			}
		}
		return first;
	}
	
	private LinkedChar(Character c) {
		this.c = c;
	}
	
	public String toString() {
		LinkedChar c = this;
		StringBuilder builder = new StringBuilder();
		while (c != null) {
			builder.append(c.c);
			c = c.next;
		}
		return builder.toString();
	}
	
	public LinkedChar offset(int x) {
		LinkedChar c = this;
		int direction = 0;
		if (x < 0) {
			direction = -1;
		} else {
			direction = 1;
		}
		while (x != 0 && c != null) {
			x -= direction;
			if (direction > 0) {
				c = c.next;
			} else {
				c = c.prev;
			}
		}
		return c;
	}
	
	public LinkedChar next() {
		return offset(1);
	}
	
	
	public LinkedChar prev() {
		return offset(-1);
	}
	
	public int index() {
		LinkedChar c = this.prev;
		int index = 0;
		while (c != null) {
			c = c.prev;
			index++;
		}
		return index;
	}
	
	public LinkedChar first() {
		LinkedChar c = this;
		while (c.prev != null) {
			c = c.prev;
		}
		return c;
	}
	
	public LinkedChar last() {
		LinkedChar c = this;
		while (c.next != null) {
			c = c.next;
		}
		return c;
	}
	
	public int length() {
		LinkedChar c = this;
		int length = 0;
		while (c != null) {
			c = c.next;
			length++;
		}
		return length;
	}
	
	// insert right after current character
	public void after(LinkedChar n) {
		LinkedChar nStart = n.first();
		LinkedChar nEnd = n.last();
		// link end of list
		nEnd.next = this.next;
		this.next.prev = nEnd;
		// link beggining of list
		nStart.prev = this;
		this.next = nStart;
	}
	
	public void before(LinkedChar n) {
		LinkedChar nStart = n.first();
		LinkedChar nEnd = n.last();
		LinkedChar prev = this.prev;
		LinkedChar next = this.next;
		// link beggining of list
		prev.next = nStart;
		nStart.prev = prev;
		// link end of list
		this.prev = nEnd;
		nEnd.next = this;
	}
	
	public void insert(LinkedChar n, int index) {
		LinkedChar c = this.first().offset(index);
		c.after(n);
	}
	
	public static void main(String[] args) {
		LinkedChar c = text("this is a string");
		System.out.println(c.toString());
		System.out.println(c.index());
		System.out.println(c.length());
		System.out.println(c.next().next().next().next().toString());
		System.out.println(c.next().next().next().next().index());
		System.out.println(c.next().next().next().next().length());
		
		c.insert(text("test "), 9);
		System.out.println(c.toString());
	}

}
