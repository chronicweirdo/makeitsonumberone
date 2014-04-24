package com.chronicweirdo.makeitso.ontology;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.hp.hpl.jena.tdb.TDBLoader;

public class JenaTDB {

	private static String readQuery(String fileName) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			br.close();
			String everything = sb.toString();
			return everything;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void updateDB(String directory, String url) {
		Model model = TDBFactory.createModel(directory);
		TDBLoader.loadModel(model, url, true);
		model.close();
	}

	private static void executeQuery(String directory, String queryFile, String outputFile) {
		Model model = TDBFactory.createModel(directory);

		String queryString = readQuery(queryFile);
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			
			Model model2 = qexec.execConstruct();
			StmtIterator iterator = model2.listStatements();
			int i = 1;
			while (iterator.hasNext()) {
				Statement stmt = iterator.next();
				
				System.out.println(i + ". " + stmt.toString());
				i++;
			}
			
			//writeResultSet(qexec.execSelect(), outputFile);
		} finally {
			qexec.close();
		}

		model.close();
	}
	
	private static void writeResultSet(ResultSet results, String fileName) {
		try { 
			File file = new File(fileName);
 
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (; results.hasNext();) {
				QuerySolution soln = results.nextSolution();
				bw.write(results.getRowNumber() + ". "
						+ soln.toString() + "\n");
			}
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dbDirectory = "MyDatabases/DB1";
		String source1Url = "/Users/cacovean/Downloads/nlx_stage_all.rdf";
		// updateDB(dbDirectory, source1Url);
		//System.out.println("system predicates:");
		//executeQuery(dbDirectory, "queries/query2");
		
		System.out.println("values for some predicate:");
		executeQuery(dbDirectory, "queries/query5", "results/result5");
	}

}
