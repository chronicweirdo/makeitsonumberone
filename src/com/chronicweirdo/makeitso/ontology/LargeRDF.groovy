package com.chronicweirdo.makeitso.ontology

import java.nio.file.Path
import java.nio.file.Paths

import com.hp.hpl.jena.query.Dataset
import com.hp.hpl.jena.query.Query
import com.hp.hpl.jena.query.QueryExecution
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.ResultSet
import com.hp.hpl.jena.query.ResultSetFormatter
import com.hp.hpl.jena.rdf.model.Model
import com.hp.hpl.jena.tdb.TDBFactory
import com.hp.hpl.jena.tdb.TDBLoader


class LargeRDF {

	static query(String path) {
		//Model model = openFile(path);
		//Model model = TDBFactory.createModel(path);
		//TDBQuery.
		Dataset dataset = TDBFactory.createDataset(path)
		
		String queryString = """\
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>

			select *
			where {
				<http://bbp.epfl.ch/project/smwtesting/Special:URIResolver/SilviuTestCell> ?p ?o
			} limit 100
		"""
		/*List r = executeSelectQuery(model, query);
		println r.size()
		int line = 1;
		r.each{
			it.each { key, value ->
				println "$line :: $key :: $value"
			}
			print "\n";
			line++;
		}
		model.close();*/
		Query query = QueryFactory.create(queryString) ;
		QueryExecution qexec = QueryExecutionFactory.create(query, dataset) ;
		ResultSet results = qexec.execSelect() ;
		ResultSetFormatter.out(results) ;
	}
	
	private static void updateDB(String directory, String url) {
		Model model = TDBFactory.createModel(directory);
		TDBLoader.loadModel(model, url, true);
		model.close();
	}
	
	static copyDataset(Path original, Path copy) {
		Model model = TDBFactory.createModel(original.toString());
		copy.toFile().withWriter { out ->
			model.write(out);
		}
	}
	
	static main(args) {
		Path database = Paths.get(System.getProperty("user.home"), "largeRDF");
		Path file = Paths.get(System.getProperty("user.home"), "2013.10.28.rdf");
		Path copy = Paths.get(System.getProperty("user.home"), "2013.10.28.bkp.rdf");
		//updateDB(database.toString(), file.toString())
		//query(database.toString());
		copyDataset(database, copy)
	}

}
