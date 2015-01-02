package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.model.Section;
import org.chronicweirdo.dump.parsers.Parser;
import org.chronicweirdo.dump.parsers.ReferenceParser;
import org.chronicweirdo.dump.parsers.XPathParser;
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
public class Builder {

    private Viewer viewer;
    private String masterTemplate;
    private Map<String, Parser> parsers;
    private Map<String, String> templates;

    public Builder() {
        try {
            this.viewer = new Viewer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMasterTemplate(String masterTemplate) {
        this.masterTemplate = masterTemplate;
    }

    public void setParsers(Map<String, Parser> parsers) {
        this.parsers = parsers;
    }

    public void setTemplates(Map<String, String> templates) {
        this.templates = templates;
    }

    public String convert(Post post) {
        /*StringBuilder builder = new StringBuilder();
        // write header
        builder.append("<html><body>");
        // write content
        for (Section section: post.getSections()) {
            writeSection(builder, section);
        }
        // write footer
        builder.append("</body></html>");
        return builder.toString();*/
        Map model = new HashMap<>(1);
        List<String> sections = new ArrayList<>(post.getSections().size());
        for (Section section: post.getSections()) {
            sections.add(getSectionText(section));
        }
        model.put("sections", sections);
        model.put("title", post.getTitle());
        return viewer.apply(model, masterTemplate);
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
