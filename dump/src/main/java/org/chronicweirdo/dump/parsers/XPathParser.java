package org.chronicweirdo.dump.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scacoveanu on 12/30/2014.
 */
public class XPathParser implements Parser {

    public static final String HTML_BODY_ELEMENTS = "/html/body/*";


    private Map<String, String> xpaths = new HashMap<>();
    private XPath xpath;
    private DocumentBuilder documentBuilder;
    private boolean toList = true;

    public XPathParser() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        XPathFactory xPathfactory = XPathFactory.newInstance();
        xpath = xPathfactory.newXPath();
    }

    public void addXPath(String modelKey, String xPathDefinition) {
        xpaths.put(modelKey, xPathDefinition);
    }

    @Override
    public Map parse(File file) {
        Map model = new HashMap<>();

        Document doc = getDocument(file);
        if (doc == null) {
            // can't parse
            return model;
        }

        for (Map.Entry<String, String> xpath: xpaths.entrySet()) {
            NodeList nodeList = getNodes(doc, xpath.getValue());
            if (nodeList != null) {
                for (int index = 0; index < nodeList.getLength(); index ++) {
                    addToModel(model, xpath.getKey(), node2String(nodeList.item(index)));
                }
            }
        }

        return model;
    }

    private void addToModel(Map model, String key, String data) {
        if (! model.containsKey(key)) {
            if (toList) {
                model.put(key, new ArrayList<String>());
            } else {
                model.put(key, "");
            }
        }
        if (toList) {
            ((ArrayList<String>) model.get(key)).add(data);
        } else {
            String existing = (String) model.get(key);
            String value = existing + data;
            model.put(key, value);
        }
    }

    private NodeList getNodes(Document doc, String xpath) {
        try {
            XPathExpression expr = this.xpath.compile(xpath);
            return (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Document getDocument(File file) {
        try {
            return documentBuilder.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String node2String(Node node) {
        try {
            // you may prefer to use single instances of Transformer, and
            // StringWriter rather than create each time. That would be up to your
            // judgement and whether your app is single threaded etc
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(node), xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        XPathParser parser = new XPathParser();
        parser.addXPath("content", HTML_BODY_ELEMENTS);
        Map model = parser.parse(new File("data/[y.2014][mo.01][d.02][h.11][m.00][ti.maven][t.programming][t.cheatsheet].html"));
        System.out.println(model);
    }
}
