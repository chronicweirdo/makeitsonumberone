package org.chronicweirdo.patcher.scanner;

import org.junit.Test;

/**
 * Created by scacoveanu on 10/17/2014.
 */
public class ScannerTest {

    @Test
    public void scan() throws Exception {
//        String root = "C:\\ipaserver\\web\\WEB-INF\\lib";
        String root = "C:\\ipaserver\\web\\WEB-INF";
        for (Entry e: Scanner.scan(root)) {
            System.out.println(e.getPath() + "   " + e.getName());
        }
    }
}
