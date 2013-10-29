

import java.nio.file.Path
import java.nio.file.Paths

import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.tooling.GlobalGraphOperations

import com.chronicweirdo.makeitso.graph.neo4j.TestNeo4j
import com.hp.hpl.jena.rdf.model.Literal
import com.hp.hpl.jena.rdf.model.Model
import com.hp.hpl.jena.rdf.model.ModelFactory
import com.hp.hpl.jena.rdf.model.Property
import com.hp.hpl.jena.rdf.model.Resource
import com.hp.hpl.jena.util.FileManager

class RDFToNeo4J {

	static Map convertResource(Resource resource) {
		def r = [:]
		r["type"] = "resource"
		if (resource.nameSpace) {
			r["namespace"] = resource.getNameSpace()
		}
		if (resource.localName) {
			r["localname"] = resource.getLocalName()
		}
		return r
	}
	
	static Map convertProperty(Property property) {
		return ["type": "property", "namespace": property.getNameSpace(),
			"localname": property.getLocalName()];
	}
	
	static Map convertLiteral(Literal literal) {
		return ["type": "literal", "value": literal.getValue().toString()]
	}
	
	static test() {
		Path graphPath = Paths.get(System.getProperty("user.home"), "Documents", "workspace", "rdfdump", "graphdb");
		Path modelPath = Paths.get(System.getProperty("user.home"), "Documents", "workspace", "rdfdump", "2013.10.14.10.24.37");
		// read model
		Model model = ModelFactory.createDefaultModel();
		InputStream input = FileManager.get().open(modelPath.toString());
		model.read(input, null);
		// open graph
		GraphDatabaseService graph = TestNeo4j.open(graphPath);
		// insert every statement into the graph
		model.listStatements().each { statement ->
			/*Resource subject = statement.getSubject(); 
			println subject.toString()
			println subject.getNameSpace() + " / " + subject.getLocalName()
			Property predicate = statement.getPredicate();
			println predicate.getNameSpace() + " / " + predicate.getLocalName()
			RDFNode object = statement.getObject();
			if (object.isLiteral()) {
				Literal literal = object.asLiteral();
				println literal.getValue();
			} else if (object.isResource()) {
				Resource resource = object.asResource();
				println resource.getNameSpace() + " / " + resource.getLocalName()
			}*/
			Map s = convertResource(statement.getSubject())
			Map p = convertProperty(statement.getPredicate())
			Map o = null;
			if (statement.getObject().isLiteral()) {
				o = convertLiteral(statement.getObject().asLiteral());
			} else {
				o = convertResource(statement.getObject().asResource());
			}
			println s
			println p
			println o
			TestNeo4j.addLink(graph, s, o, p, TestNeo4j.RelTypes.ONTOLOGY);
			print "\n"
		}
		// close model
		model.close();
		
		GlobalGraphOperations ggo.
	}
	
	
	static main(args) {
		test();
	}

}
