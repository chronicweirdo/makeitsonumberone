package com.chronicweirdo.makeitso.lucene;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
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
	
	public static Document getDocument(File file) throws Exception {
		Document document = new Document();
		document.add(new TextField("title", file.getName(), Field.Store.YES));
		FileReader reader = new FileReader(file);
		document.add(new TextField("contents", reader));
		return document;
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
					Document document = getDocument(file);
					iwriter.addDocument(document);
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
	    ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;

	    System.out.println(hits.length);
	    for (int i = 0; i < hits.length; i++) {
	      Document hitDoc = isearcher.doc(hits[i].doc);
	      System.out.println(hitDoc.get("title"));
	    }
	    ireader.close();
	}
	
	public static void main(String[] args) throws Exception {
		//testSimpleIndex(null);
		String path = "/Users/cacovean/Dropbox/mydata/wiki";
		String indexPath = "/Users/cacovean/Dropbox/mydata/wiki/.index";
		//Directory index = buildFolderIndex(indexPath, path);
		Directory index = FSDirectory.open(new File(indexPath));
		//index.listAll();
		//System.out.println(index);
		searchIndex(index, "title", "apache_jena.txt");
		searchIndex(index, "contents", "#bbp");
		index.close();
	}

}
