package org.chronicweirdo.dump;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 12/29/2014.
 *
 * http://blog.stackhunter.com/2014/01/17/10-reasons-to-replace-your-jsps-with-freemarker-templates/
 */
public class TemplatingTest {


    @Test
    public void templatePlusModel() throws Exception {
        // configure
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDirectoryForTemplateLoading(new File("templates"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

        Map<String, Object> input = new HashMap<>();
        input.put("title", "Test template");
        input.put("me", new ValueExampleObject("Some object", "test dev"));
        List systems = new ArrayList();
        systems.add(new ValueExampleObject("object 2", "the boss"));
        Map three = new HashMap<>();
        three.put("name", "map name");
        three.put("developer", "map developer");
        systems.add(three);
        input.put("systems", systems);

        Template template = configuration.getTemplate("test.ftl");

        System.out.println(input);

        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);
    }

    public static class ValueExampleObject {
        private String name;
        private String developer;

        private ValueExampleObject(String name, String developer) {
            this.name = name;
            this.developer = developer;
        }

        public String getName() {
            return name;
        }

        public String getDeveloper() {
            return developer;
        }
    }
}
