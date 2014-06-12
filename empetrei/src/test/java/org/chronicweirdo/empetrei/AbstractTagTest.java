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

    protected List<String> filePaths;

    @Before
    public void setUp() throws Exception {
        filePaths = new ArrayList<String>(2);
        filePaths.add("C:\\Users\\scacoveanu\\Dropbox\\music\\rock\\alternative\\Noir Desir - Vive la Fete.mp3");
        filePaths.add("C:\\Users\\scacoveanu\\Dropbox\\music\\rock\\Regula de Aur.mp3");
        filePaths.add("C:\\Users\\scacoveanu\\Dropbox\\music\\rock\\hardcore\\08 - Gauze.mp3");
        filePaths.add("C:\\Users\\scacoveanu\\Dropbox\\music\\playlists\\(2014.02.18) Melancholy Sips (chronicweirdo)\\08. Flowers From The Man Who Shot Your Cousin - Lay Down Your Arms.mp3");
    }

    protected MediaFile getMediaFile(String path) {
        File mp3File = new File(path);
        assertNotNull(mp3File);
        assertTrue(mp3File.exists());

        MediaFile mediaFile = new MP3File(mp3File);
        assertNotNull(mediaFile);
        return mediaFile;
    }
}
