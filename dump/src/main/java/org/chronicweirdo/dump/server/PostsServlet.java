package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.service.Builder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by scacoveanu on 12/31/2014.
 */
public class PostsServlet extends HttpServlet {

    private List<Post> posts;
    private Builder builder = new Builder();

    public PostsServlet(List<Post> posts) {
        this.posts = posts;
    }

    private boolean accept(String url) {
        // check if it has a number
        String index = url.substring(url.lastIndexOf("/")+1);
        try {
            Integer.parseInt(index);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (! accept(url)) {
            return;
        };
        String index = url.substring(url.lastIndexOf("/")+1);
        int ii = Integer.parseInt(index);
        resp.setContentType("text/html");
        try {
            resp.getWriter().write(builder.convert(posts.get(ii)));
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
}
