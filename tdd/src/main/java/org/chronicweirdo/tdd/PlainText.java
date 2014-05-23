package org.chronicweirdo.tdd;

/**
 * Created by scacoveanu on 5/23/2014.
 */
public class PlainText implements Segment {

    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlainText plainText = (PlainText) o;

        if (!text.equals(plainText.text)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
