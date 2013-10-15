package com.chronicweirdo.makeitso.graph.indexgraph

class Node {

	List<String> value;
	
	Node(String ... s) {
		value = new ArrayList();
		s.each {
			value.add(it);
		}
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
		if (this == obj)
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
			for (i in 0..value.size()) {
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
