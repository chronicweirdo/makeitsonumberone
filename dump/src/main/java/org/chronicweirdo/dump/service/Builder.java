package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.Util;
import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.model.Section;
import org.chronicweirdo.dump.parsers.Parser;
import org.chronicweirdo.dump.parsers.ReferenceParser;
import org.chronicweirdo.dump.parsers.XPathParser;
import org.chronicweirdo.dump.view.Viewer;

import java.io.*;

/**
 * Service that takes a post and returns a html file.
 *
 * Created by scacoveanu on 12/29/2014.
 */
public class Builder {

    private Viewer viewer;

    public Builder() {
        try {
            this.viewer = new Viewer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String convert(Post post) {
        StringBuilder builder = new StringBuilder();
        // write header
        builder.append("<html><body>");
        // write content
        for (Section section: post.getSections()) {
            writeFile(builder, section.getFile(), section.getCaption(), section.getIndex());
        }
        // write footer
        builder.append("</body></html>");
        return builder.toString();
    }

    private void writeFile(StringBuilder builder, File file, String caption, String index) {
        String extension = getExtension(file);
        Parser parser = getParser(extension);
        String template = getTemplate(extension);
        if (parser != null && template != null) {
            builder.append(viewer.apply(parser.parse(file), template));
        }
    }

    private Parser getParser(String name) {
        if ("png".equalsIgnoreCase(name)) {
            return new ReferenceParser();
        } else if ("html".equalsIgnoreCase(name)) {
            XPathParser p = new XPathParser();
            p.addXPath("contents", XPathParser.HTML_BODY_ELEMENTS);
            return p;
        }
        return null;
    }

    private String getTemplate(String name) {
        if ("png".equalsIgnoreCase(name)) {
            return "image";
        } else if ("html".equalsIgnoreCase(name)) {
            return "contents";
        }
        return null;
    }

    /*private void writeHtml(StringBuilder builder, File file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            boolean write = false;
            String line;
            while((line = br.readLine()) != null){
                int startIndex = line.indexOf("<body>");
                if (startIndex > -1) {
                    write = true;
                    line = line.substring(startIndex + 6);
                }
                if (write) {
                    int stopIndex = line.indexOf("</body>");
                    if (stopIndex > -1) {
                        write = false;
                        line = line.substring(0, stopIndex);
                    }
                    builder.append(line);
                }
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeImage(StringBuilder builder, File file) {
        builder.append("<img src=\"" + Util.getServerPath(file) + "\" />");
    }*/



    private String getExtension(File file) {
        return file.getName().substring(file.getName().lastIndexOf('.')+1);
    }
}
