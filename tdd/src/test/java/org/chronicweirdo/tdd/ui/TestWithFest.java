package org.chronicweirdo.tdd.ui;

import org.fest.assertions.Assertions;
import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.finder.FrameFinder;
import org.fest.swing.finder.JFileChooserFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JFileChooserFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Test;
import static org.fest.swing.edt.GuiActionRunner.*;

import javax.swing.*;
import java.io.File;


/**
 * Created by scacoveanu on 6/25/2014.
 */
public class TestWithFest extends FestSwingJUnitTestCase {

    private FrameFixture editor;

    protected void onSetUp() {
        editor = new FrameFixture(robot(), createNewEditor());
    }

    @RunsInEDT
    private static HTMLDocumentEditor createNewEditor() {
        return execute(new GuiQuery<HTMLDocumentEditor>() {
            protected HTMLDocumentEditor executeInEDT() {
                return new HTMLDocumentEditor();
            }
        });
    }

    @Test
    public void shouldOpenFile() {
        editor.menuItemWithPath("File", "Open").click();
        JFileChooserFixture fileChooserFixture = JFileChooserFinder.findFileChooser().using(robot());
        fileChooserFixture.setCurrentDirectory(new File("tdd")).selectFile(new File("test_driving_web_components.html")).approve();
        Assertions.assertThat(editor.textBox("document").text()).contains("web components");
    }

}
