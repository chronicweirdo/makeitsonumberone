package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.model.Section;
import org.chronicweirdo.dump.parsers.Parser;
import org.chronicweirdo.dump.parsers.ReferenceParser;
import org.chronicweirdo.dump.parsers.XPathParser;
import org.chronicweirdo.dump.view.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.*;

/**
 * Service that takes a post and returns a html file.
 *
 * Created by scacoveanu on 12/29/2014.
 */
@Service
public class BuilderService {

    private Viewer viewer;
    private String defaultMaster;
    private Map<String, Parser> parsers = new HashMap<>();
    private Map<String, String> templates = new HashMap<>();

    @Autowired
    private SourceService sourceService;

    public void setSourceService(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    public BuilderService() {
        try {
            this.viewer = new Viewer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() {
        // default master template
        this.setDefaultMaster("post");

        // parsers
        XPathParser htmlParser = new XPathParser();
        htmlParser.addXPath("contents", XPathParser.HTML_BODY_ELEMENTS);
        this.addParser("html", htmlParser);
        ReferenceParser imageParser = new ReferenceParser();
        this.addParser("png", imageParser);
        this.addParser("jpg", imageParser);

        // templates
        this.addTemplate("html", "contents");
        this.addTemplate("png", "image");
        this.addTemplate("jpg", "image");
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
        model.put("tags", post.getTags());
        model.put("next", sourceService.getNextPost(post));
        model.put("previous", sourceService.getPreviousPost(post));
        model.putAll(getDateMap(post));
        String master = post.getMaster();
        if (master == null) {
            master = defaultMaster;
        }
        return viewer.apply(model, master);
    }

    public static Map<String, String> getDateMap(Post post) {
        Map<String, String> map = new HashMap<>(5);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(post.getCreationDate());

        map.put("year", dateFieldToString(calendar.get(Calendar.YEAR)));
        map.put("month", dateFieldToString(calendar.get(Calendar.MONTH) + 1));
        map.put("day", dateFieldToString(calendar.get(Calendar.DAY_OF_MONTH)));
        map.put("hour", dateFieldToString(calendar.get(Calendar.HOUR_OF_DAY)));
        map.put("minute", dateFieldToString(calendar.get(Calendar.MINUTE)));

        return map;
    }
    private static String dateFieldToString(Integer field) {
        String s = field.toString();
        if (s.length() == 1) {
            return "0" + s;
        }
        return s;
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
