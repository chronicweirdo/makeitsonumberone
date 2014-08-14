package org.chronicweirdo.javapuzzlers.chapter3.puzzle16;

public class LinePrinter {
    public static void main(String[] args) {
        // Note: \\u000A is Unicode representation of linefeed (LF)
        char c = 0x000A;
        System.out.println(c);
        // will not compile because of the new line which breaks the comment
    }
}
