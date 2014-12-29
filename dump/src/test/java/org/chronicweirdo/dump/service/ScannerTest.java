package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by scacoveanu on 12/29/2014.
 */
public class ScannerTest {

    @Test
    public void testScanFolder() throws Exception {
        Scanner scanner = new Scanner();
        scanner.setParser(new Parser());

        List<Post> posts = scanner.scan(new File("dump/data"));
        System.out.println(posts);
    }
}
