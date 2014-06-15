package org.chronicweirdo.empetrei;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.v2.ID3V2Tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silviu on 6/15/14.
 */
public class GenreUtil {
    public static List<String> getGenres(String path) throws Exception {
        String genreString = getID3V2Tag(path).getGenreDescription();
        List<String> genres = tokenize(genreString);
        return genres;
    }

    private static ID3v2 getID3V2Tag(String path) throws Exception {
        Mp3File file = new Mp3File(path);
        if (file.hasId3v2Tag()) {
            return file.getId3v2Tag();
        } else {
            throw new Exception("No ID3v2 tag!");
        }
    }

    public static void addGenre(String path, String genre) throws Exception {
        genre = genre.trim();
        genre = genre.toLowerCase();
        String genreString = getID3V2Tag(path).getGenreDescription();
        List<String> genres = tokenize(genreString);
        if (!(genres.contains(genre))) {
            genres.add(genre);
            String newGenreString = untokenize(genres);
            getID3V2Tag(path).setGenreDescription(newGenreString);
        }
    }

    private static String untokenize(List<String> genres) {
        String separator = "";
        StringBuilder builder = new StringBuilder();
        for (String genre: genres) {
            builder.append(separator);
            builder.append(genre);
            separator = ";";
        }
        return builder.toString();
    }

    public static List<String> tokenize(String source) {
        String[] tokens = source.split(";");
        List<String> result = new ArrayList<String>(tokens.length);
        for (String token: tokens) {
            String item = token.trim().toLowerCase();
            if (item.length() > 0) {
                result.add(item);
            }
        }
        return result;
    }
}

