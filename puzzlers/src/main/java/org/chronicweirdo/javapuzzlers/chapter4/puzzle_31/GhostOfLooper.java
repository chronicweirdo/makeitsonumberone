package org.chronicweirdo.javapuzzlers.chapter4.puzzle_31;

public class GhostOfLooper {
    public static void main(String[] args) {
        // Place your declaration for i here

        short i = -1;
        while (i != 0)
            i >>>= 1;
    }
}
