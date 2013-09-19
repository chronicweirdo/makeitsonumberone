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
import com.hp.hpl.jena.tdb.base.file.Location;

/**
 * This class is responsible with:
 * 	- reading a remote ontology and importing it into a local database
 *  - running select queries on a local database and printing the results
 *  - running construct queries on a local database and saving the resuls on another local database
 * @author cacovean
 *
 */
public class JenaEngine {

	private static String readString(String fileName) {
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
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeModel(Model model, String fileName) {
		try { 
			File file = new File(fileName);
 
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			StmtIterator iterator = model.listStatements();
			int i = 1;
			while (iterator.hasNext()) {
				Statement stmt = iterator.next();
				
				bw.write(i + ". " + stmt.toString() + "\n");
				i++;
			}
			bw.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void updateDB(String directory, String url) {
		Model model = TDBFactory.createDataset(directory).getDefaultModel();
		TDBLoader.loadModel(model, url, true);
		model.close();
	}
	
	private static void executeConstructQuery(String sourceDirectory, String destinationDirectory, String queryFile, String outputFile) {
		Model sourceModel = TDBFactory.createDataset(sourceDirectory).getDefaultModel();
		Model destinationModel = TDBFactory.createDataset(destinationDirectory).getDefaultModel();

		String queryString = readString(queryFile);
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, sourceModel);
		try {
			query.isConstructType();
			qexec.execConstruct(destinationModel);
			writeModel(destinationModel, outputFile);
		} finally {
			qexec.close();
		}

		sourceModel.close();
		destinationModel.close();
	}

	private static void executeSelectQuery(String directory, String queryFile, String outputFile) {
		Model model = TDBFactory.createDataset(directory).getDefaultModel();

		String queryString = readString(queryFile);
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			writeResultSet(qexec.execSelect(), outputFile);
		} finally {
			qexec.close();
		}

		model.close();
	}
	
	private static void executeRemoteSelectQuery(String url, String queryFile, String outputFile) {
		//Model model = TDBFactory.createDataset(directory).getDefaultModel();
		
		String queryString = readString(queryFile);
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(url, query);
		try {
			writeResultSet(qexec.execSelect(), outputFile);
		} finally {
			qexec.close();
		}
		
		//model.close();
	}
	
	private static void testLocal() {
		String neurolexDB = "MyDatabases/DB1";
		String slimsDB = "MyDatabases/DB2";
		String source1Url = "/Users/cacovean/Downloads/nlx_stage_all.rdf";
		// updateDB(dbDirectory, source1Url);
		//System.out.println("system predicates:");
		//executeQuery(dbDirectory, "queries/query2");
		
		System.out.println("STARTING");
		//executeConstructQuery(neurolexDB, slimsDB, "queries/query5", "results/result5");
		executeSelectQuery(slimsDB, "queries/query6", "results/result6");
		System.out.println("END");
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://localhost:8000/sparql";
		
		System.out.println("STARTING");
		executeRemoteSelectQuery(url, "sparqlQuery", "sparqlResult");
		System.out.println("END");
	}

}
