package org.chronicweirdo.dump;

import org.chronicweirdo.dump.model.Source;
import org.chronicweirdo.dump.parsers.ReferenceParser;
import org.chronicweirdo.dump.parsers.XPathParser;
import org.chronicweirdo.dump.scanners.FileNameScanner;
import org.chronicweirdo.dump.server.TheServer;
import org.chronicweirdo.dump.service.BuilderService;
import org.chronicweirdo.dump.service.ScannerService;
import org.chronicweirdo.dump.service.SourceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;
import java.util.Arrays;
import java.util.List;

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
        return source;
    }

    private static BuilderService getBuilderService() {
        BuilderService builderService = new BuilderService();

        // default master template
        builderService.setDefaultMaster("postPage");

        // parsers
        XPathParser htmlParser = new XPathParser();
        htmlParser.addXPath("contents", XPathParser.HTML_BODY_ELEMENTS);
        builderService.addParser("html", htmlParser);
        ReferenceParser imageParser = new ReferenceParser();
        builderService.addParser("png", imageParser);
        builderService.addParser("jpg", imageParser);

        // templates
        builderService.addTemplate("html", "contents");
        builderService.addTemplate("png", "image");
        builderService.addTemplate("jpg", "image");

        return builderService;
    }

    private static SourceService getSourceService(List<Source> sources) {
        SourceService sourceService = new SourceService();
        sourceService.setScannerService(new ScannerService());

        for (Source source: sources) {
            // add source
            sourceService.addSource(source.getFolder().getPath());
        }

        return sourceService;
    }


    public static void main( String[] args )
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("dump/src/main/resources/context.xml");

        List<Source> sources = Arrays.asList(getSource("dump/data"), getSource("dump/data2"));

        TheServer server = context.getBean(TheServer.class);
        server.setSources(sources);
        server.setBuilderService(getBuilderService());
        server.setSourceService(getSourceService(sources));

        server.start();
        //((ConfigurableApplicationContext) context).refresh();
    }
}
