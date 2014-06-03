package org.chronicweirdo.tdd.web;

import static org.junit.Assert.*;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Before;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.*;

/**
 * Created by scacoveanu on 6/2/2014.
 */
public class VelocityTestCase {

    private VelocityContext context;
    protected Document document;

    @Before
    public void setUp() throws Exception {
        context = new VelocityContext();
    }

    protected String getWebRoot() {
        return ".";
    }

    protected void setAttribute(String name, Object value) {
        context.put(name, value);
    }

    protected void render(String templatePath) throws Exception {
        File templateFile = new File(getWebRoot(), templatePath);
        String template = readFileContent(templateFile);
        String renderedHtml = renderTemplate(template);
        this.document = parseAsXml(renderedHtml);
    }

    private String readFileContent(File file) throws Exception {
        StringBuilder builder = new StringBuilder();
        FileInputStream fstream = new FileInputStream(file);
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            builder.append(strLine);
        }
        //Close the input stream
        in.close();
        return builder.toString();
    }

    private Document parseAsXml(String renderedHtml) throws Exception {
        DocumentBuilderFactory dbf =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(renderedHtml));

        Document doc = db.parse(is);
        return doc;
    }

    private String renderTemplate(String template) throws Exception {
        VelocityEngine engine = new VelocityEngine();
        engine.init();
        StringWriter writer = new StringWriter();
        engine.evaluate(context, writer, "test", template);
        return writer.toString();
    }

    protected void assertFormFieldValue(String name, String expectedValue) throws Exception {
        String xpath = xpathForField(name);
        assertNodeExists(xpath);
        String actual = getString(xpath + "/@value");
        assertEquals(expectedValue, actual);
    }

    private String getString(String xpath) throws Exception {
        return (String) evaluate(xpath, XPathConstants.STRING);
    }

    private void assertNodeExists(String xpath) throws Exception {
        assertNotNull("Node doesn't exist: " + xpath, getNode(xpath));
    }

    private Node getNode(String xpath) throws Exception {
        return (Node) evaluate(xpath, XPathConstants.NODE);
    }

    private Object evaluate(String xpath, QName type) throws Exception {
        XPath engine = XPathFactory.newInstance().newXPath();
        return engine.evaluate(xpath, getResponse(), type);
    }

    private Object getResponse() {
        return document;
    }

    private String xpathForField(String name) {
        return "//form//input[@name='" + name + "']";
    }
}
