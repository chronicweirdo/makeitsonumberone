package org.chronicweirdo.dump;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.scanners.FileNameScanner;
import org.chronicweirdo.dump.service.BuilderService;
import org.chronicweirdo.dump.service.ScannerService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by scacoveanu on 12/29/2014.
 */
public class BuilderServiceServerTest {

    @Test
    public void createServer() throws Exception {
        Server server = new Server(8080);

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase(".");

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resource_handler, context });
        server.setHandler(handlers);

        ScannerService scannerService = new ScannerService();

        List<Post> posts = scannerService.scan(new File("data"), new FileNameScanner());

        context.addServlet(new ServletHolder(new PostsServlet(posts)), "/*");
        //context.addServlet(new ServletHolder(new DefaultServlet()), "/*");

        server.start();
        server.join();
    }

    private class PostsServlet  extends HttpServlet {

        private List<Post> posts;
        private BuilderService builderService = new BuilderService();

        private PostsServlet(List<Post> posts) {
            this.posts = posts;
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String url = req.getRequestURL().toString();
            String index = url.substring(url.lastIndexOf("/")+1);
            int ii = Integer.parseInt(index);
            resp.setContentType("text/html");
            try {
                resp.getWriter().write(builderService.convert(posts.get(ii)));
                resp.setStatus(HttpServletResponse.SC_OK);
            } catch (IOException e) {
                throw new ServletException(e);
            }
        }

    }
}
