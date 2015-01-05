package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.model.Source;
import org.chronicweirdo.dump.parsers.ReferenceParser;
import org.chronicweirdo.dump.parsers.XPathParser;
import org.chronicweirdo.dump.scanners.FileNameScanner;
import org.chronicweirdo.dump.service.BuilderService;
import org.chronicweirdo.dump.service.FileNameParser;
import org.chronicweirdo.dump.service.ScannerService;
import org.chronicweirdo.dump.service.SourceService;
import org.eclipse.jetty.rewrite.handler.RewriteHandler;
import org.eclipse.jetty.rewrite.handler.RewritePatternRule;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 12/31/2014.
 */
@Component
public class TheServer {

    @Autowired
    private HomeHandler homeHandler;

    private List<Source> sources;

    public void setHomeHandler(HomeHandler homeHandler) {
        this.homeHandler = homeHandler;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public void start() {
        Server server = new Server(getPort());

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        RewriteHandler rewriteHandler = new RewriteHandler();
        rewriteHandler.setHandler(context);
        rewriteHandler.setRewritePathInfo(false);
        rewriteHandler.setRewriteRequestURI(false);
        RewritePatternRule rootRule = new RewritePatternRule();
        rootRule.setPattern("");
        rootRule.setReplacement("/home");
        rewriteHandler.addRule(rootRule);

        BuilderService builderService = new BuilderService();
        XPathParser htmlParser = new XPathParser();
        htmlParser.addXPath("contents", XPathParser.HTML_BODY_ELEMENTS);
        builderService.addParser("html", htmlParser);
        builderService.addTemplate("html", "contents");
        ReferenceParser imageParser = new ReferenceParser();
        builderService.addParser("png", imageParser);
        builderService.addTemplate("png", "image");
        builderService.addParser("jpg", imageParser);
        builderService.addTemplate("jpg", "image");
        builderService.setMasterTemplate("postPage");

        SourceService sourceService = new SourceService();
        sourceService.setScannerService(new ScannerService());

        PostsHandler postsHandler = new PostsHandler();
        postsHandler.setSourceService(sourceService);
        postsHandler.setBuilderService(builderService);

        List<Handler> resourceHandlers = new ArrayList<>();
        for (Source source: sources) {
            // add source
            sourceService.addSource(source.getFolder().getPath());

            // create a resource handler
            ResourceHandler resourceHandler = new ResourceHandler();
            resourceHandler.setDirectoriesListed(false);
            resourceHandler.setResourceBase(source.getFolder().getPath());
            resourceHandlers.add(resourceHandler);
        }



        HandlerCollection handlerCollection = new HandlerCollection();
        //handlerCollection.addHandler(rewriteHandler); TODO: why does this work even if it's not added?
        handlerCollection.addHandler(homeHandler);
        handlerCollection.addHandler(postsHandler);
        for (Handler handler: resourceHandlers) {
            handlerCollection.addHandler(handler);
        }
        handlerCollection.addHandler(new DefaultHandler());
        server.setHandler(handlerCollection);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private int getPort() {
        return 8080;
    }
}
