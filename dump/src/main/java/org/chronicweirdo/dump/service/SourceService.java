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

    public List<Post> getPosts() {
        return posts;
    }


    public Collection<String> getSources() {
        return this.sources.keySet();
    }

    public Collection<String> getResources() {
        return this.resources;
    }
}
