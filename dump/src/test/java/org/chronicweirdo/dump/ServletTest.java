package org.chronicweirdo.dump;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by scacoveanu on 12/24/2014.
 *
 * https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
 */
public class ServletTest {

    @Test
    public void createServerWithServlet() throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new HelloServlet("greeting message")), "/*");

        server.start();
        server.join();
    }

    private class HelloServlet extends HttpServlet {
        private String greeting;

        private HelloServlet(String greeting) {
            this.greeting = greeting;
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>" + greeting + "</h1>");
        }
    }

}
