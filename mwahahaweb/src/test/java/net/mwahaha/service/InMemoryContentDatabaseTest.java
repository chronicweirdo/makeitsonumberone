package net.mwahaha.service;

import net.mwahaha.model.Page;
import net.mwahaha.model.Tag;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 10/29/2014.
 */
public class InMemoryContentDatabaseTest {

    @Test
    public void test() throws Exception {
        Path source = Paths.get(System.getProperty("user.home"), "Dropbox", "documente");

        DiskScanner scanner = new DiskScanner(source);
        Interpreter fileInterpreter = new FileNameInterpreter();
        scanner.addInterpreter(fileInterpreter);
        ContentDatabase database = new InMemoryContentDatabase(scanner);

        List<Tag> tags = new ArrayList<>();
        Tag tag = new Tag();
        tag.setName("test");
        tags.add(tag);
        List<Page> result = database.getAllFor(tags);
        //List<Page> result = database.getAll();

        for (Page page: result) {
            System.out.println(page.getPath());
        }
    }
}
