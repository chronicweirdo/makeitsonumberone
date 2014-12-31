package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.service.FileNameParser;
import org.chronicweirdo.dump.service.Scanner;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created by scacoveanu on 12/31/2014.
 */
@Component
public class TheServer {

    public void start() {
        Server server = new Server(getPort());

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase(".");

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resource_handler, context });
        server.setHandler(handlers);

        Scanner scanner = new Scanner();
        scanner.setFileNameParser(new FileNameParser());

        List<Post> posts = scanner.scan(new File("data"));

        //context.addServlet(new ServletHolder(new PostsServlet(posts)), "/*");
        //context.addServlet(new ServletHolder(new DefaultServlet()), "/*");

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
