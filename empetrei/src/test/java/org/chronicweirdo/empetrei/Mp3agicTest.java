package org.chronicweirdo.empetrei;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Silviu on 6/15/14.
 */
public class Mp3agicTest extends AbstractTagTest {

    @Test
    public void readTag() throws Exception {
        Mp3File file = new Mp3File(filePathWithMultipleGenres);
        System.out.println(file.hasId3v2Tag());
        System.out.println(file.hasId3v1Tag());

        ID3v2 tag = file.getId3v2Tag();
        System.out.println(tag.getGenre());
        System.out.println(tag.getGenreDescription());
    }
}
