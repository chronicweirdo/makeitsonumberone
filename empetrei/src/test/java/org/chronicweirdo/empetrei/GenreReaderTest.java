package org.chronicweirdo.empetrei;

import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.ID3Tag;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.MediaFile;
import org.blinkenlights.jid3.v2.ID3V2Tag;
import org.blinkenlights.jid3.v2.ID3V2_3_0Tag;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 6/12/2014.
 */
public class GenreReaderTest {

    private List<String> filePaths;

    @Before
    public void setUp() throws Exception {
        filePaths = new ArrayList<String>(2);
        filePaths.add("C:\\Users\\scacoveanu\\Dropbox\\music\\rock\\alternative\\Noir Desir - Vive la Fete.mp3");
        filePaths.add("C:\\Users\\scacoveanu\\Dropbox\\music\\rock\\Regula de Aur.mp3");
        filePaths.add("C:\\Users\\scacoveanu\\Dropbox\\music\\rock\\hardcore\\08 - Gauze.mp3");
    }

    @Test
    public void testReadGenre() throws Exception {
        File mp3File = new File(filePaths.get(0));
        assertNotNull(mp3File);
        assertTrue(mp3File.exists());

        MediaFile mediaFile = new MP3File(mp3File);
        assertNotNull(mediaFile);

        //ID3V2_3_0Tag tag = new ID3V2_3_0Tag();

        id3Tags(mediaFile);
    }

    private void id3v2Tag(MediaFile mediaFile) throws Exception {
        ID3V2Tag tag = mediaFile.getID3V2Tag();
        assertNotNull(tag);

        String genre = tag.getGenre();
        assertNotNull(genre);
        System.out.println(genre);
    }

    private void id3Tags(MediaFile mediaFile) throws Exception {
        ID3Tag[] tags = mediaFile.getTags();
        assertNotNull(tags);
        assertNotEquals(0, tags.length);

        for (ID3Tag tag: tags) {
            System.out.println(tag.getClass().getName());
        }
    }
}
