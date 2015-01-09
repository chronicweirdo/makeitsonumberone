package org.chronicweirdo.dump.server;

import org.chronicweirdo.dump.Util;
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
import java.util.*;

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
        if ("filterNext".equals(url)) {
            String filterType = request.getParameter("type");
            List<String> tags = Arrays.asList(request.getParameterValues("tag"));
            String title = request.getParameter("title");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String hour = request.getParameter("hour");
            String minute = request.getParameter("minute");
            Date date = Util.getDate(year, month, day, hour, minute);
            Post nextPost = sourceService.getNextPost(sourceService.getPost(title, date), filterType, tags);
            System.out.println(nextPost.getTitle());
        }
        if ("filterPrevious".equals(url)) {
            String filterType = request.getParameter("type");
            List<String> tags = Arrays.asList(request.getParameterValues("tag"));
            String title = request.getParameter("title");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String hour = request.getParameter("hour");
            String minute = request.getParameter("minute");
            Date date = Util.getDate(year, month, day, hour, minute);
            Post previousPost = sourceService.getPreviousPost(sourceService.getPost(title, date), filterType, tags);
            System.out.println(previousPost.getTitle());
        }
    }
}
