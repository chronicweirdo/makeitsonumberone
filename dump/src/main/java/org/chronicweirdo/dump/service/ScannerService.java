package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.scanners.Scanner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Service that scans a folder and returns a list of posts.
 *
 * Created by scacoveanu on 12/29/2014.
 */
public class ScannerService {

    public List<Post> scan(File root, Scanner scanner) {
        List<Post> posts = new ArrayList<Post>();
        try {
            scan(root, posts, scanner);
        } catch (FormattingException e) {
            System.out.println(e);
        }
        return posts;
    }

    private void scan(File file, List<Post> posts, Scanner scanner) throws FormattingException {
        if (file.isFile()) {
            Post filePost = scanner.scan(file);
            if (filePost != null) {
                Post existingPost = findPost(posts, filePost);
                if (existingPost == null) {
                    posts.add(filePost);
                } else {
                    existingPost.merge(filePost);
                }
            }
        } else {
            for (File child : file.listFiles()) {
                try {
                    scan(child, posts, scanner);
                } catch (FormattingException e) {
                    System.out.println(e);
                }
            }
        }
    }

    private Post findPost(List<Post> posts, Post filePost) {
        for (Post post: posts) {
            if (post.equals(filePost)) {
                return post;
            }
        }
        return null;
    }


}
