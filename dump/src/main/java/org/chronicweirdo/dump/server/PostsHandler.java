package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.model.Source;
import org.chronicweirdo.dump.service.BuilderService;
import org.chronicweirdo.dump.service.SourceService;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 12/31/2014.
 */
public class PostsHandler extends AbstractHandler {

    private Source source;
    private Map<String, Post> posts;
    private BuilderService builderService;
    private SourceService sourceService;

    public void setSourceService(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    public void setBuilderService(BuilderService builderService) {
        this.builderService = builderService;
    }

    public PostsHandler() {
    }

    private void load() {
        this.posts = new HashMap<>();
        List<Post> posts = sourceService.getPosts();
        for (Post post: posts) {
            for (String url: getUrls(post)) {
                this.posts.put(url, post);
            }
        }
    }

    private List<String> getUrls(Post post) {
        return Arrays.asList(post.getTitle().replaceAll("\\s","_"));
    }

    private String convert(String target) {
        if (target.startsWith("/")) {
            return target.substring(1);
        }
        return target;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (posts == null) {
            load();
        }
        String url = convert(target);
        if (posts.containsKey(url)) {
            response.setContentType("text/html");
            try {
                response.getWriter().write(builderService.convert(posts.get(url)));
                response.setStatus(HttpServletResponse.SC_OK);
                baseRequest.setHandled(true);
            } catch (IOException e) {
                throw new ServletException(e);
            }
        }
    }
}
