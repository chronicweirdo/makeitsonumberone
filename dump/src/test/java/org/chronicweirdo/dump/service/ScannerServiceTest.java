package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.scanners.FileNameScanner;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by scacoveanu on 12/29/2014.
 */
public class ScannerServiceTest {

    @Test
    public void testScanFolder() throws Exception {
        ScannerService scannerService = new ScannerService();

        List<Post> posts = scannerService.scan(new File("data"), new FileNameScanner());
        System.out.println(posts);
    }
}
