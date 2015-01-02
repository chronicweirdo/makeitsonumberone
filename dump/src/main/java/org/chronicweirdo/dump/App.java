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
    public static void main( String[] args )
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("dump/src/main/resources/context.xml");

        TheServer server = context.getBean(TheServer.class);
        Source source = new Source();
        source.setFolder(new File("dump/data"));
        source.setScanner(new FileNameScanner());
        source.setMasterTemplate("postPage");
        XPathParser htmlParser = new XPathParser();
        htmlParser.addXPath("contents", XPathParser.HTML_BODY_ELEMENTS);
        source.addParserTemplate("html", htmlParser, "contents");
        ReferenceParser imageParser = new ReferenceParser();
        source.addParserTemplate("png", imageParser, "image");
        source.addParserTemplate("jpg", imageParser, "image");

        Source source2 = new Source();
        source2.setMasterTemplate("postPage");
        source2.setFolder(new File("dump/data2"));
        source2.setScanner(new FileNameScanner());
        source2.setMasterTemplate("postPage");
        source2.addParserTemplate("html", htmlParser, "contents");
        source2.addParserTemplate("jpg", imageParser, "image");

        server.setSources(Arrays.asList(source, source2));

        server.start();
        //((ConfigurableApplicationContext) context).refresh();
    }
}
