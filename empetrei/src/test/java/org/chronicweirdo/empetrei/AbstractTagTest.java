package org.chronicweirdo.empetrei;

import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.MediaFile;
import org.junit.Before;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by scacoveanu on 6/12/2014.
 */
public abstract class AbstractTagTest {

    protected String filePathWithCover = "temp\\music\\Wrath of God.mp3";
    protected String filePathWithoutCover = "temp\\music\\Hanging Around.mp3";

    protected MediaFile getMediaFile(String path) {
        File mp3File = new File(path);
        assertNotNull(mp3File);
        assertTrue(mp3File.exists());

        MediaFile mediaFile = new MP3File(mp3File);
        assertNotNull(mediaFile);
        return mediaFile;
    }
}
