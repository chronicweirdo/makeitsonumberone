package com.chronicweirdo.makeitso.ontology

import java.nio.file.Path
import java.nio.file.Paths

import com.hp.hpl.jena.query.Query
import com.hp.hpl.jena.query.QueryExecution
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.QuerySolution
import com.hp.hpl.jena.query.ResultSet
import com.hp.hpl.jena.rdf.model.Model
import com.hp.hpl.jena.rdf.model.ModelFactory
import com.hp.hpl.jena.util.FileManager

class RDFFileReader {

	static Model openFile(Path path) {
		Model model = ModelFactory.createDefaultModel();
		InputStream input = FileManager.get().open(path.toString());
		model.read(input, null);
	}
	
	static List executeSelectQuery(Model model,  String queryString) {
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		List result = null;
		try {
			result = convertResultSet(qexec.execSelect());
		} finally {
			qexec.close();
		}
		
		return result;
	}
	
	static List convertResultSet(ResultSet results) {
		List converted = new ArrayList();
		println "names: " + results.getResultVars()
		results.each {
			Map c = [:]
			for (var in results.getResultVars()) {
				c[var] = it.get(var);
			}
			converted.add(c);
		}
		return converted;
	}
	
	private static void writeResultSet(ResultSet results, StringBuilder builder) {
		for (; results.hasNext();) {
			QuerySolution soln = results.nextSolution();
			builder.append(results.getRowNumber())
				.append(". ").append(soln.toString())
				.append("\n");
		}
	}
	
	static void printResultSet(ResultSet results) {
		try {
			
			StringBuilder builder = new StringBuilder();
			writeResultSet(results, builder);
			
			print builder.toString();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void executeRemoteSelectQuery(String url, String queryFile, String outputFile) {
		String queryString = readString(queryFile);
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(url, query);
		try {
			writeResultSet(qexec.execSelect(), outputFile);
		} finally {
			qexec.close();
		}
	}
	
	static String buildQuery(String subject, String predicate, String object) {
		StringBuilder builder = new StringBuilder();
		builder.append("select *").append('\n');
		builder.append("where {").append('\n');
		if (subject) {
			builder.append(subject)
		} else {
			builder.append("?subject")
		}
		builder.append(" ");
		if (predicate) {
			builder.append(predicate)
		} else {
			builder.append("?predicate");
		}
		builder.append(" ");
		if (object) {
			builder.append(object);
		} else {
			builder.append("?object")
		}
		//builder.append('\n');
		builder.append("}");
		return builder.toString();
	}
	
	static main(args) {
		String remoteQuery = """\
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>

			select *
			from <http://example.org/mediawikigraph>
			where {
				?s <http://example.org/mediawiki/index.php/Special:URIResolver/Property-3ATestproperty> ?o
			} LIMIT 100
		"""
		/*String query = """\
				select *
				where {
					?s ?p ?o
				}
				"""*/
		//String query = buildQuery(null, null, null);
		String query = buildQuery("<http://example.org/mediawiki/index.php/Special:URIResolver/Dummypage>"
			, "<http://www.w3.org/2000/01/rdf-schema#label>", "'Dummypage'");
		
		println query;
		
		//Path path = Paths.get("/", "Volumes", "rdfdump", "2013.10.14.10.24.37");
		Path path = Paths.get(System.getProperty("user.home"), "Documents", "workspace", "rdfdump", "2013.10.14.10.24.37");
		Model model = openFile(path)
		
		List r = executeSelectQuery(model, query);
		println r.size()
		r.each{
			it.each { key, value ->
				println "$key :: $value"
			}
			print "\n";
		}
		
		model.close();
	}

}
