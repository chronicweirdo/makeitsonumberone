package org.chronicweirdo.empetrei;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import org.blinkenlights.jid3.MediaFile;
import org.blinkenlights.jid3.v2.ID3V2Frame;
import org.blinkenlights.jid3.v2.ID3V2Tag;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Silviu on 6/15/14.
 */
public class TestAlbumArt extends AbstractTagTest {


    @Test
    public void extractAlbumArt() throws Exception {
        String filePath = "temp\\music\\Wrath of God.mp3";
        Mp3File song = new Mp3File(filePath);
        if (song.hasId3v2Tag()){
            ID3v2 id3v2tag = song.getId3v2Tag();
            byte[] imageData = id3v2tag.getAlbumImage();
            //converting the bytes to an image
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
            ImageIO.write(img, "jpg", new File("temp\\music\\cover.jpg"));
        }
    }
}
