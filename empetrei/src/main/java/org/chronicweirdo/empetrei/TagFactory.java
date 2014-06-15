package org.chronicweirdo.empetrei;

import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.v1.ID3V1Tag;
import org.blinkenlights.jid3.v2.ID3V2Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silviu on 6/15/14.
 */
public class TagFactory {

    public static List<String> tokenize(String source) {
        String[] tokens = source.split(";");
        List<String> result = new ArrayList<String>(tokens.length);
        for (String token: tokens) {
            String item = token.trim();
            if (item.length() > 0) {
                result.add(item);
            }
        }
        return result;
    }

    public static Tag createTag(ID3V1Tag source) {
        Tag tag = new Tag();
        tag.setArtist(source.getArtist());
        tag.setTitle(source.getTitle());
        tag.setArtist(source.getAlbum());
        tag.setTrack("");
        tag.setDate(source.getYear());
        tag.setGenres(tokenize(source.getGenre().toString()));
        return tag;
    }

    public static Tag createTag(ID3V2Tag source) {
        Tag tag = new Tag();
        tag.setArtist(source.getArtist());
        tag.setTitle(source.getTitle());
        tag.setAlbum(source.getAlbum());
        try {
            tag.setTrack(Integer.toString(source.getTrackNumber()));
        } catch (ID3Exception e) {
        }
        try {
            tag.setDate(Integer.toString(source.getYear()));
        } catch (ID3Exception e) {
        }
        tag.setGenres(tokenize(source.getGenre()));
        return tag;
    }
}
