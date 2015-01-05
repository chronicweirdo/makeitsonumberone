package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.model.Section;
import org.chronicweirdo.dump.parsers.Parser;
import org.chronicweirdo.dump.view.Viewer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service that takes a post and returns a html file.
 *
 * Created by scacoveanu on 12/29/2014.
 */
public class BuilderService {

    private Viewer viewer;
    private String defaultMaster;
    private Map<String, Parser> parsers = new HashMap<>();
    private Map<String, String> templates = new HashMap<>();

    public BuilderService() {
        try {
            this.viewer = new Viewer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefaultMaster(String defaultMaster) {
        this.defaultMaster = defaultMaster;
    }

    public void setParsers(Map<String, Parser> parsers) {
        this.parsers = parsers;
    }

    public void setTemplates(Map<String, String> templates) {
        this.templates = templates;
    }

    public void addParser(String name, Parser parser) {
        this.parsers.put(name, parser);
    }

    public void addTemplate(String name, String template) {
        this.templates.put(name, template);
    }

    public String convert(Post post) {

        Map model = new HashMap<>(1);
        List<String> sections = new ArrayList<>(post.getSections().size());
        for (Section section: post.getSections()) {
            sections.add(getSectionText(section));
        }
        model.put("sections", sections);
        model.put("title", post.getTitle());
        String master = post.getMaster();
        if (master == null) {
            master = defaultMaster;
        }
        return viewer.apply(model, master);
    }

    private String getSectionText(Section section) {
        return viewer.apply(
                parsers.get(section.getProcessor()).parse(section.getFile()),
                templates.get(section.getProcessor())
        );
    }
    private void writeSection(StringBuilder builder, Section section) {
        builder.append(viewer.apply(parsers.get(section.getProcessor()).parse(section.getFile()), templates.get(section.getProcessor())));
    }

}
