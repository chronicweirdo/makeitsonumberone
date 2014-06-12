package org.chronicweirdo.empetrei;

import org.blinkenlights.jid3.MediaFile;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 6/12/2014.
 */
public class TagConversionTest extends AbstractTagTest {

    @Test
    public void testConvertTags() throws Exception {
        MediaFile mediaFile = getMediaFile(filePaths.get(3));
        System.out.println(mediaFile.getID3V1Tag());
        System.out.println(mediaFile.getID3V1Tag().getClass().getName());
        System.out.println("----");
        System.out.println(mediaFile.getID3V2Tag());
        System.out.println(mediaFile.getID3V2Tag().getClass().getName());

        MP3Tag tag1 = new MP3Tag(mediaFile.getID3V1Tag());
        System.out.println(tag1);
        MP3Tag tag2 = new MP3Tag(mediaFile.getID3V2Tag());
        System.out.println(tag2);
    }

}
