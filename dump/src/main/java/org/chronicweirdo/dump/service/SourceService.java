package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.scanners.FileNameScanner;
import org.chronicweirdo.dump.scanners.Scanner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 1/5/2015.
 */
public class SourceService {

    private Map<String, Scanner> sources = new HashMap<>();

    private List<String> resources = new ArrayList<String>();

    private List<Post> posts;

    private ScannerService scannerService;

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

    private void scan() {
        this.posts = new ArrayList<>();
        for (Map.Entry<String, Scanner> source: sources.entrySet()) {
            posts.addAll(this.scannerService.scan(new File(source.getKey()), source.getValue()));
        }
    }

    public List<Post> getPosts() {
        return posts;
    }
}
