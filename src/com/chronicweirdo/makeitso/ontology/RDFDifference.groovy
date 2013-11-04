package com.chronicweirdo.makeitso.ontology

import java.nio.file.Path
import java.nio.file.Paths

import com.hp.hpl.jena.rdf.model.Model
import com.hp.hpl.jena.rdf.model.ModelFactory
import com.hp.hpl.jena.util.FileManager

class RDFDifference {
	
	static Model getModel(Path path) {
		Model model = ModelFactory.createDefaultModel();
		InputStream input = FileManager.get().open(path.toString());
		model.read(input, null);
		return model
	}
	
	static Model createModel() {
		return ModelFactory.createDefaultModel()
	}
	
	static saveModel(Path path, Model model) {
		path.toFile().withWriter { out ->
			model.write(out);
		}
	}
	
	public static class Pair {
		def minus;
		def plus;
	}

	static Pair difference(Model oldModel, Model newModel) {
		// find the difference between two files
		// find old - new:
		Model plusModel = createModel()
		newModel.listStatements().each { statement ->
			if (!oldModel.contains(statement)) {
				// this statement was added
				plusModel.add(statement);
			}
		}
		// find new - old
		Model minusModel = createModel()
		oldModel.listStatements().each { statement ->
			if (!newModel.contains(statement)) {
				// this statement was deleted
				minusModel.add(statement)
			}
		}
		return new Pair(minus: minusModel, plus: plusModel)
	}
	
	static union() {
		// we have input file A and difference files B+ and B-
		// load all three files
		// remove from A all triplets in B-
		// add to A all triplets in B+
		// save to C
	}
	
	static Model build(pairs) {
		// a set of difference file pairs (the first file is just an add, without a remove)
		// is taken and successively combined to get to the current RDF version
		Model result = createModel()
		pairs.each { pair ->
			if (pair.plus) {
				Model plus = getModel(pair.plus)
				plus.listStatements().each { statement ->
					result.add(statement)
				}
			}
			if (pair.minus) {
				Model minus = getModel(pair.minus)
				minus.listStatements().each { statement ->
					result.remove(statement)
				}
			}
		}
		return result
	}
	
	static buildFile() {
		Path root = Paths.get(System.getProperty("user.home"), "Documents", "workspace", "rdfdump")
		Path diff = root.resolve("diff")
		def archives = [
			"2013.10.14.10.24.37",
			"2013.10.14.10.57.02",
			"2013.10.14.11.07.13",
			"2013.10.14.11.54.01",
			"2013.10.14.12.00.01",
			"2013.10.14.12.20.01",
			"2013.10.14.12.40.03",
			"2013.10.14.13.00.01",
			"2013.10.14.13.20.03",
			"2013.10.14.13.40.01",
			"2013.10.14.14.00.01",
			"2013.10.14.14.20.02",
			"2013.10.14.14.40.01"
			]
		def pairs = archives.collect {
			new Pair(minus: diff.resolve(it + "m"), plus: diff.resolve( it + "p"))
		}
		Model model = build(pairs)
		model.listStatements().each { statement ->
			println statement
		}
	}
	
	static buildPairs() {
		Path root = Paths.get(System.getProperty("user.home"), "Documents", "workspace", "rdfdump")
		Path diff = root.resolve("diff");
		def archives = [
			"2013.10.14.10.24.37",
			"2013.10.14.10.57.02",
			"2013.10.14.11.07.13",
			"2013.10.14.11.54.01",
			"2013.10.14.12.00.01",
			"2013.10.14.12.20.01",
			"2013.10.14.12.40.03",
			"2013.10.14.13.00.01",
			"2013.10.14.13.20.03",
			"2013.10.14.13.40.01",
			"2013.10.14.14.00.01",
			"2013.10.14.14.20.02",
			"2013.10.14.14.40.01"
			]
		// load models
		def models = archives.collect {
			getModel(root.resolve(it))
		}
		// save initial pair
		saveModel(diff.resolve(archives[0] + "p"), models[0])
		saveModel(diff.resolve(archives[0] + "m"), createModel())
		// compute and save pairs
		(1..models.size()-1).each { index ->
			Pair pair = difference(models[index-1], models[index])
			saveModel(diff.resolve(archives[index] + "p"), pair.plus)
			saveModel(diff.resolve(archives[index] + "m"), pair.minus)
		}
		
	}
	
	static main(args) {
		/*Path root = Paths.get(System.getProperty("user.home"), "Documents", "workspace", "rdfdump")
		Path pathOld = Paths.get("2013.10.14.10.24.37")
		Path pathNew = Paths.get("2013.10.14.14.40.01")
		Path pathPlus = Paths.get("plus")
		Path pathMinus = Paths.get("minus")
		Pair result = difference(getModel(root.resolve(pathOld)), getModel(root.resolve(pathNew)));
		saveModel(root.resolve(pathPlus), result.plus)
		saveModel(root.resolve(pathMinus), result.minus)*/
		//buildPairs()
		buildFile()
	}

}
