package org.chronicweirdo.tdd.web;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Before;
import org.w3c.dom.Document;

import java.io.File;
import java.io.StringWriter;

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
        return null;
    }

    private Document parseAsXml(String renderedHtml) throws Exception {
        return null;
    }

    private String renderTemplate(String template) throws Exception {
        VelocityEngine engine = new VelocityEngine();
        engine.init();
        StringWriter writer = new StringWriter();
        engine.evaluate(context, writer, "test", template);
        return writer.toString();
    }


}
