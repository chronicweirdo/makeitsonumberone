package org.chronicweirdo.tdd.ui;

import junit.extensions.abbot.ComponentTestFixture;

import java.awt.*;

/**
 * Created by Silviu on 6/23/14.
 */
public class TestPlotMapViewImpl extends ComponentTestFixture
    implements PlotAdditionListener {

    public TestPlotMapViewImpl() {
        super("TestPlotMapViewImpl");
    }

    private Point addedPoint;

    public void plotWasAdded(Point plot) {
        addedPoint = plot;
    }

    @Override
    protected void fixtureSetUp() throws Throwable {
        super.fixtureSetUp();
        addedPoint = null;
        PlotMapViewImpl view = new PlotMapViewImpl();
        view.registerAdditionListener(this);
        showFrame(view);
    }

    public void testAdditionEventGetsTriggered() throws Exception {
        Point point = new Point(3, 5);

    }
}
