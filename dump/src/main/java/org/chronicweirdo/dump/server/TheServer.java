package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.service.FileNameParser;
import org.chronicweirdo.dump.service.Scanner;
import org.eclipse.jetty.rewrite.handler.RewriteHandler;
import org.eclipse.jetty.rewrite.handler.RewritePatternRule;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created by scacoveanu on 12/31/2014.
 */
@Component
public class TheServer {

    @Autowired
    private HomeServlet homeServlet;

    public void setHomeServlet(HomeServlet homeServlet) {
        this.homeServlet = homeServlet;
    }

    public void start() {
        Server server = new Server(getPort());

        //ResourceHandler resourceHandler = new ResourceHandler();
        // don't list directories
        //resourceHandler.setDirectoriesListed(false);
        //resourceHandler.setResourceBase(".");



        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        //context.setResourceBase(".");

        RewriteHandler rewriteHandler = new RewriteHandler();
        rewriteHandler.setHandler(context);
        RewritePatternRule rootRule = new RewritePatternRule();
        rootRule.setPattern("");
        rootRule.setReplacement("/home");
        rootRule.setTerminating(true);
        rewriteHandler.addRule(rootRule);



        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { /*rewriteHandler,*/ context/*, resourceHandler*/ });
        //server.setHandler(handlers);
        server.setHandler(rewriteHandler);

        context.addServlet(new ServletHolder(homeServlet), "/home/");

        Scanner scanner = new Scanner();
        scanner.setFileNameParser(new FileNameParser());
        List<Post> posts = scanner.scan(new File("data"));
        context.addServlet(new ServletHolder(new PostsServlet(posts)), "/*");

        DefaultServlet defaultServlet = new DefaultServlet();
        ServletHolder defaultServletHolder = new ServletHolder(defaultServlet);
        defaultServletHolder.setInitParameter("dirAllowed", "false");
        defaultServletHolder.setInitParameter("resourceBase", "./data/");
        context.addServlet(defaultServletHolder, "/*");

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
