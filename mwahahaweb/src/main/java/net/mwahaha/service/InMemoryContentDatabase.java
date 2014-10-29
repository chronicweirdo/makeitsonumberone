package net.mwahaha.service;

import net.mwahaha.model.Page;
import net.mwahaha.model.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 10/29/2014.
 */
public class InMemoryContentDatabase implements ContentDatabase {

    private List<Page> data; // TODO: have a better data structure to enable searching
    private Scanner scanner;

    public InMemoryContentDatabase(Scanner scanner) {
        this.scanner = scanner;
        data = scanner.scan();
        // TODO: start a thread to periodically check for updates
    }

    @Override
    public List<Page> getAllFor(List<Tag> tags) {
        List<Page> result = new ArrayList<Page>();
        for (Page page: data) {
            boolean matches = true;
            for (Tag tag: tags) {
                if (!page.getTags().contains(tag)) {
                    matches = false;
                }
            }
            if (matches) {
                result.add(page);
            }
        }
        return result;
    }

    @Override
    public List<Page> getAll() {
        return data;
    }
}
