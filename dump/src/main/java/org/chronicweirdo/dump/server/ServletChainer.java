package org.chronicweirdo.dump.server;

import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silviu on 1/1/2015.
 */
public class ServletChainer extends HttpServlet {

    List<HttpServlet> servlets = new ArrayList<HttpServlet>();

    public void addServlet(HttpServlet servlet) {
        servlets.add(servlet);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        for (HttpServlet servlet: servlets) {
            servlet.service(req, res);
            if (res.getStatus() == HttpServletResponse.SC_OK) {
                return;
            }
        }
    }
}
