package org.chronicweirdo.tdd.ui;

/**
 * Created by Silviu on 6/23/14.
 */
public interface PlotMapView {

    void registerAdditionListener(PlotAdditionListener listener);

    void registerRemovalListener(PlotRemovalListener listener);

    void drawPlotMap(PlotMapModel model);
}
