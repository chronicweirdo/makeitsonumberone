package org.chronicweirdo.javapuzzlers.chapter4.puzzle_32;

public class CurseOfLooper {
    public static void main(String[] args) {
        // Place your declarations for i and j here

        //Double i = Double.NEGATIVE_INFINITY;
        //Double j = Double.NEGATIVE_INFINITY;
        Integer i = new Integer(0);
        Integer j = new Integer(0);
        while (i <= j && j <= i && i != j) {
            System.out.println("-");
        }
    }
}
