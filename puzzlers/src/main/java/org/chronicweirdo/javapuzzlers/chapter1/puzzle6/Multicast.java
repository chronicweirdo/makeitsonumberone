package org.chronicweirdo.javapuzzlers.chapter1.puzzle6;

public class Multicast {
    public static void main(String[] args) {
        System.out.println((int) (char) (byte) -1); // will print 129 (binary 10000001)- wrong!
        /*
        Behavior depends on sign extension behavior of casts.
         */
    }
}
