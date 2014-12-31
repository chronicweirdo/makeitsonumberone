package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.view.Viewer;
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
public class HomeServlet extends HttpServlet{

    @Autowired
    private Viewer viewer;

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        System.out.println(url);
        //if ("http://localhost:8080/".equals(url) || "http://localhost:8080".equals(url)) {
            try {
                resp.getWriter().write(getPage());
                resp.setStatus(HttpServletResponse.SC_OK);
            } catch (IOException e) {
                throw new ServletException(e);
            }
        /*} else {
            resp.setStatus(HttpServletResponse.SC_CONTINUE);
        }*/
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
