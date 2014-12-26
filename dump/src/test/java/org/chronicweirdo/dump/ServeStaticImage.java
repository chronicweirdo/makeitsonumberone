package org.chronicweirdo.dump;

import org.chronicweirdo.dump.web.ImageServlet;
import org.chronicweirdo.dump.web.StaticHTMLServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.Test;

/**
 * Created by Silviu on 12/26/2014.
 */
public class ServeStaticImage {

    @Test
    public void createServerWithServlet() throws Exception {
        Server server = new Server(80);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new ImageServlet()), "/comic");

        server.start();
        server.join();
    }
}
