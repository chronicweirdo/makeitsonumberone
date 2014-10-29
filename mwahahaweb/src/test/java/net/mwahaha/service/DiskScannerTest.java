package net.mwahaha.service;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by scacoveanu on 10/29/2014.
 */
public class DiskScannerTest {

    @Test
    public void getFiles() throws Exception {
        Path path = Paths.get(System.getProperty("user.home"), "Dropbox", "documente");
        System.out.println(path);

        DiskScanner scanner = new DiskScanner(path);
        //Date date = null;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 28);
        Date date = calendar.getTime();
        for (File file: scanner.getFiles(date)) {
            System.out.println(file.getAbsolutePath());
        }


    }
}
