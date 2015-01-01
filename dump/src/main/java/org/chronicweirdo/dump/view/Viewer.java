package org.chronicweirdo.dump.view;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.chronicweirdo.dump.Util;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scacoveanu on 12/30/2014.
 */
@Service
public class Viewer {

    private final Configuration configuration;

    public Viewer() throws IOException {
        configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDirectoryForTemplateLoading(new File("dump/templates"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
    }

    public String apply(Map model, String view) {
        try {
            Template template = configuration.getTemplate(view + ".ftl");
            StringWriter writer = new StringWriter();
            template.process(model, writer);
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Viewer viewer = new Viewer();
        System.out.println(Util.map("url", "images/test.png"));
        String text = viewer.apply(Util.map("url", "images/test.png"), "image");
        System.out.println(text);
        System.out.println(viewer.apply(Util.map("url", "images/test.png", "caption", "a beautiful image"), "image"));
    }
}
