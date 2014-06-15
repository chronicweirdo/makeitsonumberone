package org.chronicweirdo.empetrei;

import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.ID3Tag;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.MediaFile;
import org.blinkenlights.jid3.v1.ID3V1_0Tag;
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
public class JID3GenreReaderTest extends AbstractTagTest {

    @Test
    public void testReadGenre() throws Exception {
        MediaFile mediaFile = getMediaFile(filePathWithCover);
        id3Tags(mediaFile);
    }

    @Test
    public void testReadTags() throws Exception {
        MediaFile mediaFile = getMediaFile(filePathWithCover);
        id3Tags(mediaFile);
        id3TagsRead(mediaFile);
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

    private void id3TagsRead(MediaFile mediaFile) throws Exception {
        ID3Tag[] tags = mediaFile.getTags();
        assertNotNull(tags);
        assertNotEquals(0, tags.length);

        for (ID3Tag tag: tags) {
            if (tag instanceof ID3V1_0Tag) {
                readTag((ID3V1_0Tag) tag);
            } else if (tag instanceof ID3V2_3_0Tag) {
                readTag((ID3V2_3_0Tag) tag);
            }
        }
    }

    private void readTag(ID3V2_3_0Tag tag) {
        System.out.println(tag.getClass().getName());
        System.out.println(tag.getArtist());
        System.out.println(tag.getTitle());
        System.out.println(tag.getGenre());
    }

    private void readTag(ID3V1_0Tag tag) {
        System.out.println(tag.getClass().getName());
        System.out.println(tag.getArtist());
        System.out.println(tag.getTitle());
        System.out.println(tag.getGenre());
    }
}
