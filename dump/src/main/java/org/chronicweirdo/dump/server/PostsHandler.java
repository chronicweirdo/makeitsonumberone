package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.service.Builder;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by scacoveanu on 12/31/2014.
 */
public class PostsHandler extends AbstractHandler {

    private List<Post> posts;
    private Builder builder = new Builder();

    public PostsHandler(List<Post> posts) {
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

    private Integer convert(String target) {
        if (target.startsWith("/")) {
            target = target.substring(1);
        }
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer index = convert(target);
        if (index != null && index >= 0 && index < posts.size()) {
            response.setContentType("text/html");
            try {
                response.getWriter().write(builder.convert(posts.get(index)));
                response.setStatus(HttpServletResponse.SC_OK);
                baseRequest.setHandled(true);
            } catch (IOException e) {
                throw new ServletException(e);
            }
        }
    }
}
