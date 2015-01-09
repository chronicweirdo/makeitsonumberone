package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.model.Source;
import org.chronicweirdo.dump.scanners.FileNameScanner;
import org.chronicweirdo.dump.scanners.Scanner;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.*;

/**
 * Created by scacoveanu on 1/5/2015.
 */
@Service
public class SourceService {

    private Map<String, Scanner> sources = new HashMap<>();

    private List<String> resources = new ArrayList<String>();

    private List<Post> posts;

    private ScannerService scannerService;



    @PostConstruct
    public void init() {
        this.setScannerService(new ScannerService());

        String[] sources = {"dump/data", "dump/data2"};

        for (String source: sources) {
            // add source
            this.addSource(source);
        }

        this.addResource("dump/styles");
        this.addResource("dump/js");
    }

    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    public void addSource(String path) {
        this.addSource(path, new FileNameScanner());
    }
    public void addSource(String path, Scanner scanner) {
        sources.put(path, scanner);
        resources.add(path);
        scan();
    }

    public void addResource(String path) {
        this.resources.add(path);
    }

    private void scan() {
        this.posts = new ArrayList<>();
        for (Map.Entry<String, Scanner> source: sources.entrySet()) {
            posts.addAll(this.scannerService.scan(new File(source.getKey()), source.getValue()));
        }
    }

    public Post getPost(String title, Date creationDate) {
        for (Post post: posts) {
            if (title.equalsIgnoreCase(post.getTitle()) && creationDate.equals(post.getCreationDate())) {
                return post;
            }
        }
        return null;
    }

    public Post getPost(String url) {
        for (Post post: posts) {
            if (post.getUrl().equals(url)) {
                return post;
            }
        }
        return null;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Post> getPosts(String filterType, List<String> tags) {
        List<Post> filtered = new ArrayList<>();
        for (Post post: posts) {
            if (matchesFilter(post, filterType, tags)) {
                filtered.add(post);
            }
        }
        return filtered;
    }

    public Post getNextPost(Post current, String filterType, List<String> tags) {
        List<Post> filtered = getPosts(filterType, tags);
        int currentIndex = filtered.indexOf(current);
        if (currentIndex != -1 && currentIndex < filtered.size() - 1) {
            return filtered.get(currentIndex + 1);
        }
        return null;
    }

    public Post getPreviousPost(Post current, String filterType, List<String> tags) {
        List<Post> filtered = getPosts(filterType, tags);
        int currentIndex = filtered.indexOf(current);
        if (currentIndex != -1 && currentIndex > 0) {
            return filtered.get(currentIndex - 1);
        }
        return null;
    }

    private boolean matchesFilter(Post post, String filterType, List<String> tags) {
        if ("or".equalsIgnoreCase(filterType)) {
            for (String tag: tags) {
                if (post.getTags().contains(tag)) {
                    return true;
                }
            }
        } else if ("and".equalsIgnoreCase(filterType)) {
            for (String tag: tags) {
                if (! post.getTags().contains(tag)) {
                    return false;
                }
            }
            return true;
        } else if (filterType == null || filterType.length() == 0) {
            return true;
        }
        return false;
    }


    public Collection<String> getSources() {
        return this.sources.keySet();
    }

    public Collection<String> getResources() {
        return this.resources;
    }
}
