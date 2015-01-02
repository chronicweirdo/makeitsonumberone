package org.chronicweirdo.dump.model;

import org.chronicweirdo.dump.parsers.Parser;
import org.chronicweirdo.dump.scanners.Scanner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Silviu on 1/2/2015.
 *
 * each source folder has:
 filename parser - responsible with going through the folder and
 obtaining data about posts
 a list of parser/template pairs - responsible with interpreting
 post sections and putting them in a contents list (another model)
 a master template - will take all contents and put them in the final
 web page
 */
public class Source {

    private File folder;

    private Scanner scanner;

    private Map<String, Parser> parsers = new HashMap<>();
    private Map<String, String> templates = new HashMap<>();

    private String masterTemplate;

    public void addParserTemplate(String name, Parser parser, String template) {
        parsers.put(name, parser);
        templates.put(name, template);
    }

    public Parser getParser(String name) {
        return parsers.get(name);
    }

    public String getTemplate(String name) {
        return templates.get(name);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getMasterTemplate() {
        return masterTemplate;
    }

    public void setMasterTemplate(String masterTemplate) {
        this.masterTemplate = masterTemplate;
    }

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

    public Map<String, Parser> getParsers() {
        return parsers;
    }

    public Map<String, String> getTemplates() {
        return templates;
    }
}
