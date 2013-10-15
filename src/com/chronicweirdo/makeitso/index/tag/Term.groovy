package com.chronicweirdo.makeitso.index.tag

class Term {

	List<String> value;

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
		Term other = (Term) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else {
			if (value.size() != other.value.size()) return false;
			for (i in 0..value.size()) {
				if (value.get(i) != other.value.get(i)) return false;
			}
		}
		return true;
	}
	
	
}
