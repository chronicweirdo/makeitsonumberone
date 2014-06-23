package org.chronicweirdo.tdd.ui;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silviu on 6/23/14.
 */
public class PlotMapModel {

    private List<Point> plots = new ArrayList<Point>();

    public void add(Point plot) {
        plots.add(plot);
    }

    public void remove(Point plot) {
        plots.remove(plot);
    }

    public List<Point> points() {
        return plots;
    }
}
