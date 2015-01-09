package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.service.BuilderService;
import org.chronicweirdo.dump.service.SourceService;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class FilterHandler extends AbstractHandler {

    @Autowired
    private SourceService sourceService;

    public void setSourceService(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    public FilterHandler() {
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
        String url = convert(target);
        if ("filter".equals(url)) {
            System.out.println(request.getParameterMap());
            String filterType = request.getParameterMap().get("type")[0];
            String[] tags = request.getParameterMap().get("tag");
            System.out.println(sourceService.getPosts(filterType, Arrays.asList(tags)));
        }
    }
}
