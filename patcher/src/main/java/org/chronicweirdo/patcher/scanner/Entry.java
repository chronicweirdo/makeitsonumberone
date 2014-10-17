package org.chronicweirdo.patcher.scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 10/17/2014.
 */
public class Entry {

    private List<String> path = new ArrayList<String>();
    private List<String> name;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public String getExtension() {
        return name.get(name.size() - 1);
    }

    @Override
    public String toString() {
        return path.toString() + " " + name.toString();
    }
}
