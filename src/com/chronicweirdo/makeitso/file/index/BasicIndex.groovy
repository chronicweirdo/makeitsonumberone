package com.chronicweirdo.makeitso.file.index

import java.nio.file.Path

class BasicIndex implements Index {
	
	Processor processor;
	Accessor accessor;
	
	Map<Path, Set<IndexData>> data = new HashMap();
	Map<String, Map<Object, Set<IndexData>>> terms = new HashMap();

	@Override
	public void process(Path path) {
		delete(path);
		Collection d = processor.process(path);
		d.each {
			it.getSearchTerms().each { name, value ->
				addSearchTerm(name, value, it);
			};
		}
	}
	
	@Override
	public void delete(Path path) {
		if (data[path]) {
			data[path].each {
				it.getSearchTerms().each { name, value ->
					removeSearchTerm(name, value, it);
				}
			}
			data.remove(path);
		}
	} 
	
	private void addSearchTerm(String name, Object value, IndexData data) {
		if (terms[name] == null) terms[name] = new HashMap();
		if (terms[name][value] == null) terms[name][value] = new HashSet();
		terms[name][value].add(data);
	}
	
	private void removeSearchTerm(String name, Object value, IndexData data) {
		if (terms[name] && terms[name][value]) {
			terms[name][value].remove(data);
		}
	}

	@Override
	public List<IndexData> find(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void access(IndexData data) {
		// TODO Auto-generated method stub

	}

}
