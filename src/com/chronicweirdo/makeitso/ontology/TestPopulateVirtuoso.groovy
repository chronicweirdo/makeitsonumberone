package com.chronicweirdo.makeitso.ontology

import com.hp.hpl.jena.query.Query
import com.hp.hpl.jena.query.QueryExecution
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.query.ResultSet
import com.hp.hpl.jena.rdf.model.Model
import com.hp.hpl.jena.tdb.TDBFactory

class TestPopulateVirtuoso {

	static testCreate() {
		String populateQuery = """\
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
			PREFIX test: <http://bbp.epfl.ch/project/smwtesting/test/>

			CONSTRUCT {
				test:TestSubject1 rdf:label "Test Subject One" .
			} WHERE {}
		"""
		
		Query query = QueryFactory.create(populateQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://bbpsrvi04.epfl.ch:8893/sparql", query);

		try {
			Model model = qexec.execConstruct();
			model.listStatements().each { println it }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			qexec.close();
		}
	}
	
	static testSelect() {
		String selectQuery = """\
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
			PREFIX test: <http://bbp.epfl.ch/project/smwtesting/test/>

			select *
			from <http://bbp.epfl.ch/project/smwtesting/test/>
			where {
				?s ?p ?o
			}
		"""
		
		Query query = QueryFactory.create(selectQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://bbpsrvi04.epfl.ch:8893/sparql", query);

		try {
			ResultSet results = qexec.execSelect();
			results.each { println it }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			qexec.close();
		}
	}
	
	static main(args) {
		//testCreate();
		testSelect();

		
	}

}
