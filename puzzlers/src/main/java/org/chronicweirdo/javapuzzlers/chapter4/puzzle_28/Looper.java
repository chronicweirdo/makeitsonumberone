package org.chronicweirdo.javapuzzlers.chapter4.puzzle_28;

public class Looper {
    public static void main(String[] args) {
        // Place your declaration for i here

        //float i = Float.POSITIVE_INFINITY;
        //double i = 1.0 / 0.0;
        double i = 1.0e40;
        System.out.println(Math.ulp(i));
        while (i == i + 1) {
        }
    }
}
