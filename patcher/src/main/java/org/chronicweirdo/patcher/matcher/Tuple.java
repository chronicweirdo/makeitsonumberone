package org.chronicweirdo.patcher.matcher;

import java.util.Arrays;
import java.util.List;

/**
 * Created by scacoveanu on 10/17/2014.
 */
public class Tuple {

    private List data;

    public Tuple(Object ... data) {
        this.data = Arrays.asList(data);
    }

    public void add(Object entry) {
        this.data.add(entry);
    }

    public int size() {
        return data.size();
    }
}
