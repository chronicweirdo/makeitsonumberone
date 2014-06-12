package org.chronicweirdo.empetrei;

import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.v1.ID3V1Tag;
import org.blinkenlights.jid3.v1.ID3V1_0Tag;
import org.blinkenlights.jid3.v2.ID3V2Tag;
import org.blinkenlights.jid3.v2.ID3V2_3_0Tag;

/**
 * Created by scacoveanu on 6/12/2014.
 */
public class MP3Tag {

    private String artist;
    private String title;
    private String album;
    private String track;
    private String year;
    private String genre;

    public MP3Tag(ID3V1Tag tag) {
        this.artist = tag.getArtist();
        this.title = tag.getTitle();
        this.album = tag.getAlbum();
        if (this.album.length() == 0) this.album = null;
        this.track = null;
        this.year = tag.getYear();
        if (this.year.length() == 0) this.year = null;
        this.genre = tag.getGenre().toString();
    }

    public MP3Tag(ID3V2Tag tag) {
        this.artist = tag.getArtist();
        this.title = tag.getTitle();
        this.album = tag.getAlbum();
        try {
            this.track = Integer.toString(tag.getTrackNumber());
        } catch (ID3Exception e) {
            this.track = null;
        }
        try {
            this.year = Integer.toString(tag.getYear());
        } catch (ID3Exception e) {
            this.year = null;
        }
        this.genre = tag.getGenre();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "MP3Tag{" +
                "artist=" + (artist != null ? '\'' + artist + '\'' : "null")  +
                ", title=" + (title != null ? '\'' + title + '\'' : "null") +
                ", album=" + (album != null ? '\'' + album + '\'' : "null") +
                ", track=" + (track != null ? '\'' + track + '\'' : "null") +
                ", year=" + (year != null ? '\'' + year + '\'' : "null") +
                ", genre=" + (genre != null ? '\'' + genre + '\'' : "null") +
                '}';
    }
}
