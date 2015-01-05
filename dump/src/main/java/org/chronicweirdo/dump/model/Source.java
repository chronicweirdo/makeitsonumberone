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

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

}