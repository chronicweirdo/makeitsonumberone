package net.mwahaha.service;

import net.mwahaha.model.Page;
import net.mwahaha.model.Tag;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 10/29/2014.
 */
public class FileNameInterpreter implements Interpreter {

    @Override
    public boolean accepted(Object source) {
        if (source instanceof File) {
            return true;
        }
        return false;
    }

    private String[] splitExtension(String name) {
        int lastDotIndex = name.lastIndexOf('.');
        if (lastDotIndex >= 0) {
            String justName = name.substring(0, lastDotIndex);
            String extension = name.substring(lastDotIndex);
            return new String[] {justName, extension};
        } else {
            // if no extension, we assume this is a text file
            return new String[] {name, "txt"};
        }
    }

    private String getSplitRegex(String delimiterRegex) {
        return "(?<=" + delimiterRegex + ")|(?=" + delimiterRegex + ")";
    }

    protected List<String> splitTags(String name) {
        String[] split = name.split(getSplitRegex("(\\[|\\]|\\s+)"));
        List<String> result = new ArrayList<>();
        result.add("");

        int tagLevel = 0;
        for (String s: split) {
            if ("[".equals(s)) {
                tagLevel++;
            } else if ("]".equals(s)) {
                tagLevel--;
            } else if (tagLevel > 0) {
                if (s.trim().length() > 0) {
                    result.add(s.trim());
                }
            } else {
                result.set(0, result.get(0) + s);
            }
        }
        return result;
    }

    @Override
    public Page interpret(Object source) {
        File file = (File) source;
        String name = file.getName();
        String[] splitName = splitExtension(name);
        List<String> tagsAndName = splitTags(splitName[0]);

        Page page = new Page();
        page.setTitle(tagsAndName.get(0).trim());
        page.setType(splitName[1]);
        page.setPath(Paths.get(file.toURI()));
        for (int i = 1; i < tagsAndName.size(); i++) {
            Tag tag = new Tag();
            tag.setName(tagsAndName.get(i));
            page.getTags().add(tag);
        }

        return page;
    }
}
