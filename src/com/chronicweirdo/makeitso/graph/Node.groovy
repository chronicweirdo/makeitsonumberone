package com.chronicweirdo.makeitso.graph

class Node {

	List<String> value;
	
	Node(String ... s) {
		value = new ArrayList();
		s.each {
			value.add(it);
		}
	}
	
	boolean matches(List<String> regex) {
		return matches(regex, false);
	}
	boolean matches(List<String> regex, boolean strict) {
		if (strict) {
			if (regex.size() != value.size()) return false;
		} else {
			if (regex.size() > value.size()) return false;
		}
		for (i in 0..regex.size()-1) {
			if (!(value.get(i) ==~ regex.get(i))) return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		value.each {
			result = prime * result + ((it == null) ? 0 : it.hashCode());
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.is(obj))
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else {
			if (!value.size().equals(other.value.size())) return false;
			for (i in 0..value.size()-1) {
				if (value.get(i) == null) {
					if (other.value.get(i) != null) return false;
				} else if (!value.get(i).equals(other.value.get(i))) return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append('(');
		String prefix = "";
		value.each {
			b.append(prefix)
			b.append(it.toString());
			prefix = ",";
		}
		b.append(')');
		return b.toString();
	}
}
