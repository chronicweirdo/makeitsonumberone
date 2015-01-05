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
    public static void main( String[] args )
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("dump/src/main/resources/context.xml");

        TheServer server = context.getBean(TheServer.class);

        server.start();
    }
}
