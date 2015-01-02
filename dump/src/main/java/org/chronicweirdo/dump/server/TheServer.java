package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.service.FileNameParser;
import org.chronicweirdo.dump.service.ScannerService;
import org.eclipse.jetty.rewrite.handler.RewriteHandler;
import org.eclipse.jetty.rewrite.handler.RewritePatternRule;
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
import java.util.List;

/**
 * Created by scacoveanu on 12/31/2014.
 */
@Component
public class TheServer {

    @Autowired
    private HomeHandler homeHandler;

    public void setHomeHandler(HomeHandler homeHandler) {
        this.homeHandler = homeHandler;
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
        //rootRule.setLocation("/home");
        //rootRule.setTerminating(true);
        rewriteHandler.addRule(rootRule);

        ResourceHandler resourceHandler = new ResourceHandler() {
            @Override
            public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                super.handle(target, baseRequest, request, response);
                System.out.println("! handled with the resource handler");
            }
        };
        resourceHandler.setDirectoriesListed(false);
        resourceHandler.setResourceBase("./dump/data/");


        ScannerService scannerService = new ScannerService();
        scannerService.setFileNameParser(new FileNameParser());
        List<Post> posts = scannerService.scan(new File("dump/data"));

        HandlerCollection handlerCollection = new HandlerCollection();
        //handlerCollection.addHandler(rewriteHandler);
        handlerCollection.addHandler(homeHandler);
        handlerCollection.addHandler(new PostsHandler(posts));
        handlerCollection.addHandler(resourceHandler);
        handlerCollection.addHandler(new DefaultHandler());
        /*HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {
                homeHandler,
                resourceHandler,
                new DefaultHandler() });
        server.setHandler(handlers);*/
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
