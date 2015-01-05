package org.chronicweirdo.dump;

import org.chronicweirdo.dump.model.Source;
import org.chronicweirdo.dump.parsers.ReferenceParser;
import org.chronicweirdo.dump.parsers.XPathParser;
import org.chronicweirdo.dump.scanners.FileNameScanner;
import org.chronicweirdo.dump.server.TheServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App
{

    private static Source getSource(String path) {
        Source source = new Source();

        source.setFolder(new File(path));
        source.setScanner(new FileNameScanner());
        source.setMasterTemplate("postPage");
        XPathParser htmlParser = new XPathParser();
        htmlParser.addXPath("contents", XPathParser.HTML_BODY_ELEMENTS);
        source.addParserTemplate("html", htmlParser, "contents");
        ReferenceParser imageParser = new ReferenceParser();
        source.addParserTemplate("png", imageParser, "image");
        source.addParserTemplate("jpg", imageParser, "image");

        return source;
    }
    public static void main( String[] args )
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("dump/src/main/resources/context.xml");

        TheServer server = context.getBean(TheServer.class);

        server.setSources(Arrays.asList(getSource("dump/data"), getSource("dump/data2")));

        server.start();
        //((ConfigurableApplicationContext) context).refresh();
    }
}
