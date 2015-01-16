package org.chronicweirdo.dump.service;

/**
 * Created by scacoveanu on 1/16/2015.
 */
public enum Tag {
    TITLE, EXTENSION, TAG, INDEX, CAPTION, PROCESSOR, CREATED, MODIFIED, FILE_CREATED, FILE_MODIFIED;

    public String n() {
        return this.name().toLowerCase();
    }

    public static Tag v(String n) {
        return valueOf(n.toUpperCase());
    }

    public static void main(String[] args) {
        System.out.println(Tag.TITLE.n());
        System.out.println(Tag.v(Tag.TITLE.n()));
    }
}
