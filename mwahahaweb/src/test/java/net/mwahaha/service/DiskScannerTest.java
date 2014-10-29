package net.mwahaha.service;

import net.mwahaha.model.Page;
import org.junit.Before;
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

    private Path path;
    private DiskScanner scanner;

    @Before
    public void setUp() throws Exception {
        path = Paths.get(System.getProperty("user.home"), "Dropbox", "documente");
        //System.out.println(path);

        scanner = new DiskScanner(path);
        FileNameInterpreter fileInterpreter = new FileNameInterpreter();
        scanner.addInterpreter(fileInterpreter);
    }

    //@Test
    public void getFiles() throws Exception {
        Date date = getDate(null);
        for (File file: scanner.getFiles(date)) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private Date getDate(Integer day) {
        if (day == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    @Test
    public void getPages() throws Exception {
        for (Page page: scanner.scan(getDate(28))) {
            System.out.println(page.getTitle());
            System.out.println(page.getPath());
            System.out.println();
        }
    }
}
