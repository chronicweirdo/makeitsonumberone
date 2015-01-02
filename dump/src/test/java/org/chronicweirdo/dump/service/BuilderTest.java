package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.scanners.FileNameScanner;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by scacoveanu on 12/29/2014.
 */
public class BuilderTest {

    @Test
    public void testBuilder() throws Exception {
        ScannerService scannerService = new ScannerService();

        List<Post> posts = scannerService.scan(new File("data"), new FileNameScanner());

        Builder builder = new Builder();
        for (Post post: posts) {
            String html = builder.convert(post);
            System.out.println(html);
        }
    }
}
