package com.chronicweirdo.makeitso.lucene;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import com.chronicweirdo.makeitso.file.FilePathUtils;
import com.chronicweirdo.makeitso.file.FileScannerProcessor;
import com.chronicweirdo.makeitso.file.FileUtils;

public class TestLucene {

	public static void testSimpleIndex(String path) throws Exception {
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
		/*Analyzer analyzer = new Analyzer() {

			@Override
			protected TokenStreamComponents createComponents(String string,
					Reader reader) {
				return null;
			}
			
		};*/

	    // Store the index in memory:
	    Directory directory = new RAMDirectory();
	    // To store an index on disk, use this instead:
	    //Directory directory = FSDirectory.open("/tmp/testindex");
	    IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
	    IndexWriter iwriter = new IndexWriter(directory, config);
	    Document doc = new Document();
	    String text = "This is the text to be indexed.";
	    doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
	    iwriter.addDocument(doc);
	    iwriter.close();
	    
	    // Now search the index:
	    DirectoryReader ireader = DirectoryReader.open(directory);
	    IndexSearcher isearcher = new IndexSearcher(ireader);
	    // Parse a simple query that searches for "text":
	    QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "fieldname", analyzer);
	    Query query = parser.parse("text");
	    ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
	    //assertEquals(1, hits.length);
	    System.out.println(hits.length);
	    // Iterate through the results:
	    for (int i = 0; i < hits.length; i++) {
	      Document hitDoc = isearcher.doc(hits[i].doc);
	      //assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
	      System.out.println(hitDoc.get("fieldname"));
	    }
	    ireader.close();
	    directory.close();
	}
	
	public static String[] lines(File file) {
		String contents = FileUtils.readTextFile(file.getAbsolutePath());
		String[] lines = contents.split("[\n\r]");
		return lines;
	}
	
	public static List<Document> getDocuments(File file) throws Exception {
		String path = file.getAbsolutePath();
		String[] lines = lines(file);
		List<Document> documents = new ArrayList<Document>();
		int l = 1;
		for (String line: lines) {
			Document document = new Document();
			document.add(new TextField("title", file.getName(), Field.Store.YES));
			document.add(new TextField("path", file.getAbsolutePath(), Field.Store.YES));
			document.add(new IntField("line", l, Field.Store.YES));
			List<String> tags = tags(line);
			for (String tag: tags) {
				document.add(new TextField("tag", tag, Field.Store.YES));
			}
			documents.add(document);
			l++;
		}
		return documents;
	}
	
	public static Directory buildFolderIndex(String indexPath, String path) throws Exception {
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
		
		// Store the index in memory:
		Directory index = FSDirectory.open(new File(indexPath));
		
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_44, analyzer);
		final IndexWriter iwriter = new IndexWriter(index, config);
		
		FilePathUtils.scan(new File(path), new FileScannerProcessor() {

			@Override
			public Object folder(File folder) {
				return null;
			}

			@Override
			public Object file(File file) {
				try {
					for (Document document: getDocuments(file)) {
						iwriter.addDocument(document);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
		});
		
		iwriter.close();
		
		return index;
	}
	
	public static final void searchIndex(Directory index, String field, String value) throws IOException, ParseException {
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
		DirectoryReader ireader = DirectoryReader.open(index);
	    IndexSearcher isearcher = new IndexSearcher(ireader);

	    QueryParser parser = new QueryParser(Version.LUCENE_44, field, analyzer);
	    Query query = parser.parse(value);
	    System.out.println(query.toString());
	    ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;

	    System.out.println(hits.length);
	    for (int i = 0; i < hits.length; i++) {
	      Document hitDoc = isearcher.doc(hits[i].doc);
	      System.out.println(hitDoc.get("path") + " " + hitDoc.get("line") + "  ---  " + hitDoc.get("tag"));
	    }
	    ireader.close();
	}
	
	
	public static void testIndex() throws Exception {
		//testSimpleIndex(null);
		String path = "/Users/cacovean/Dropbox/mydata/wiki";
		String indexPath = "/Users/cacovean/Dropbox/mydata/wiki/.index";
		//Directory index = buildFolderIndex(indexPath, path);
		Directory index = FSDirectory.open(new File(indexPath));
		//index.listAll();
		//System.out.println(index);
		//searchIndex(index, "title", "apache_jena.txt");
		//searchIndex(index, "tag", "#tech");
		searchIndex(index, "tag", "\"#tech:lucene\"");
		searchIndex(index, "tag", "#tech");
		searchIndex(index, "tag", "lucene");
		index.close();
	}
	
	public static List<String> tags(String line) {
		List<String> tags = new ArrayList<String>();
		//Pattern pattern = Pattern.compile("((#[a-zA-Z][a-zA-Z_.0-9]*)([:][a-zA-Z_.0-9]+)?)");
		Pattern pattern = Pattern.compile("((#[a-zA-Z][\\w.]*)([:]([\\w.]+))?)");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find())
		{
		  tags.add(matcher.group(1));
		  if (matcher.group(3) != null) {
			  tags.add(matcher.group(2));
		  }
		}
		return tags;
	}
	public static void testAuxiliary() throws Exception {
		/*String path = "/Users/cacovean/Dropbox/mydata/wiki/tech/gradle.txt";
		for (String line: lines(new File(path))) {
			System.out.println(line);
			System.out.println(tags(line).toString());
			System.out.println();
		}*/
		System.out.println(tags("[] Apache Lucene http://lucene.apache.org/core/index.html #tech:lucene").toString());
	}
	public static void main(String[] args) throws Exception {
		testIndex();
		//testAuxiliary();
	}

}
