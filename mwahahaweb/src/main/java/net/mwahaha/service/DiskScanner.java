package net.mwahaha.service;

import net.mwahaha.model.Page;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by scacoveanu on 10/29/2014.
 */
public class DiskScanner implements Scanner {

    private Path source;

    private List<Interpreter> interpreters = new ArrayList<>();

    public DiskScanner(Path source) {
        this.source = source;
    }

    private List<File> getFiles(File parent, Date modifiedAfter) {
        ArrayList<File> result = new ArrayList<>();
        if (parent.isFile()) {
            if (modifiedAfter != null) {
                if (parent.lastModified() > modifiedAfter.getTime()) {
                    result.add(parent);
                }
            } else {
                result.add(parent);
            }
        } else {
            for (File child: parent.listFiles()) {
                result.addAll(getFiles(child, modifiedAfter));
            }
        }
        return result;
    }

    protected List<File> getFiles(Date modifiedAfter) {
        return getFiles(source.toFile(), modifiedAfter);
    }

    @Override
    public List<Page> scan() {
        return scan(null);
    }

    @Override
    public List<Page> scan(Date modifiedAfter) {
        return null;
    }

    @Override
    public Object load(Page page) {
        return null;
    }
}
