package org.chronicweirdo.empetrei;

import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.MediaFile;
import org.blinkenlights.jid3.v1.ID3V1Tag;
import org.blinkenlights.jid3.v2.ID3V2Tag;

import java.io.File;

/**
 * Created by Silviu on 6/15/14.
 */
public class TagHandler {
    public Tag getTag(String path) {
        MediaFile mediaFile = getMediaFile(path);
        try {
            ID3V2Tag id3V2Tag = mediaFile.getID3V2Tag();
            if (id3V2Tag != null) {
                return TagFactory.createTag(id3V2Tag);
            }
        } catch (ID3Exception e) {
            e.printStackTrace();
        }

        try {
            ID3V1Tag id3V1Tag = mediaFile.getID3V1Tag();
            if (id3V1Tag != null) {
                return TagFactory.createTag(id3V1Tag);
            }
        } catch (ID3Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private MediaFile getMediaFile(String path) {
        File mp3File = new File(path);
        MediaFile mediaFile = new MP3File(mp3File);
        return mediaFile;
    }
}
