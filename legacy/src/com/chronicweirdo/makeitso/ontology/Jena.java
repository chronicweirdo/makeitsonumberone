package com.chronicweirdo.makeitso.ontology;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

public class Jena {

	private static void executeQuery() {
		//Model model = ModelFactory.;
		String queryString = "prefix xsd: <http://www.w3.org/2001/XMLSchema#>\n"
				+ "prefix property: <http://neurolex.org/wiki/Property-3A>\n"
				+ "select DISTINCT ?name ?id where\n" 
				+ "{?x property:Id \"birnlex_779\"^^xsd:string.\n"
				+ "?cells property:Located_in ?x.\n"
				+ "?cells property:Label ?name.\n"
				+ "?cells property:Id ?id}\n";
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://rdf-stage.neuinfo.org/ds/query", query);

		try {
			ResultSet results = qexec.execSelect();
			for (; results.hasNext();) {
				QuerySolution soln = results.nextSolution();
				System.out.println(soln.toString());
			}
		} finally {
			qexec.close();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		executeQuery();
	}

}
