package org.chronicweirdo.dump;

import org.junit.Test;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by scacoveanu on 12/24/2014.
 *
 * https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
 */
public class ServerTest {

    @Test
    public void createServer() throws Exception {
        Server server = new Server(8080);
        server.setHandler(new HelloHandler());

        server.start();
        server.join();
    }

    private class HelloHandler extends AbstractHandler {
        public void handle(String s, HttpServletRequest request, HttpServletResponse response, int i) throws IOException, ServletException {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            ((Request) request).setHandled(true);
            response.getWriter().println("<h1>Hi Bub!</h1>");
        }
    }

}
