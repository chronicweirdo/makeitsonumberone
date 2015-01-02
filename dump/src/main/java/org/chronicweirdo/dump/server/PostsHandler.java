package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.model.Source;
import org.chronicweirdo.dump.service.Builder;
import org.chronicweirdo.dump.service.ScannerService;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 12/31/2014.
 */
public class PostsHandler extends AbstractHandler {

    private Source source;
    private Map<String, Post> posts;
    private Builder builder;
    private ScannerService scannerService;

    public PostsHandler() {
    }

    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    public void setSource(Source source) {
        this.source = source;
        this.builder = new Builder();
        builder.setMasterTemplate(source.getMasterTemplate());
        builder.setParsers(source.getParsers());
        builder.setTemplates(source.getTemplates());
    }

    private void load() {
        List<Post> posts = scannerService.scan(source.getFolder(), source.getScanner());
        for (Post post: posts) {
            for (String url: getUrls(post)) {
                this.posts.put(url, post);
            }
        }
    }

    private List<String> getUrls(Post post) {
        return Arrays.asList(post.getTitle());
    }

    private String convert(String target) {
        if (target.startsWith("/")) {
            return target.substring(1);
        }
        return target;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = convert(target);
        if (posts.containsKey(url)) {
            response.setContentType("text/html");
            try {
                response.getWriter().write(builder.convert(posts.get(url)));
                response.setStatus(HttpServletResponse.SC_OK);
                baseRequest.setHandled(true);
            } catch (IOException e) {
                throw new ServletException(e);
            }
        }
    }
}
