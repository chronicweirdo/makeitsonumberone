package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.view.Viewer;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scacoveanu on 12/31/2014.
 */
@Component
public class HomeHandler extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--> " + target);
        String url = request.getRequestURL().toString();
        System.out.println(url);

        if ("/home".equals(target) || "/".equals(target)) {
            System.out.println("handling this");
            try {
                response.getWriter().write(getPage());
                response.setStatus(HttpServletResponse.SC_OK);
                baseRequest.setHandled(true);
            } catch (IOException e) {
                throw new ServletException(e);
            }
        } else {
            System.out.println("not the home page, not handling");
        }
    }

    @Autowired
    private Viewer viewer;

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    private String getPage() {
        Map model = getModel();
        String template = "home";
        return viewer.apply(model, template);
    }

    private Map getModel() {
        Map model = new HashMap();
        model.put("greeting", "hello");
        return model;
    }
}