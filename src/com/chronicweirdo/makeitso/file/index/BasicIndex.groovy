package com.chronicweirdo.makeitso.file.index

import java.nio.file.Path

import com.chronicweirdo.makeitso.index.tag.old20131016.Position

class BasicIndex implements Index {
	
	Processor processor;
	Accessor accessor;
	
	Map<Path, Set<IndexData>> data = new HashMap();
	Map<String, Map<Object, Set<Position>>> terms = new HashMap();

	@Override
	public void process(Path path) {
		delete(path);
		Collection d = processor.process(path);
		if (d) {
			d.each {
				it.getSearchTerms().each { name, value ->
					addSearchTerm(name, value, it);
				};
			}
			data[path] = d;
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
		println "adding search term $name $value $data"
		if (terms[name] == null) terms[name] = new HashMap();
		if (terms[name][value] == null) terms[name][value] = new HashSet();
		terms[name][value].add(data.position);
		terms[name][value].add(data.position.filePosition());
	}
	
	private void removeSearchTerm(String name, Object value, IndexData data) {
		if (terms[name] && terms[name][value]) {
			terms[name][value].remove(data.position);
			terms[name][value].remove(data.position.filePosition());
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
