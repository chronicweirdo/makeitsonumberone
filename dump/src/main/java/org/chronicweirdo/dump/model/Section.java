package org.chronicweirdo.dump.model;

import java.io.File;

/**
 * Created by scacoveanu on 12/29/2014.
 */
public class Section {
    private File file;
    private String caption;
    private String index;
    private String processor;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
}
