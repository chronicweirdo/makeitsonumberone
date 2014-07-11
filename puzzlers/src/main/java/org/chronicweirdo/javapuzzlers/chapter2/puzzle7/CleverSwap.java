package org.chronicweirdo.javapuzzlers.chapter2.puzzle7;

public class CleverSwap {
    public static void main(String[] args) {
        int x = 1984;
        int y = 2001;
        x ^= y ^= x ^= y;
        System.out.println("x = " + x + "; y = " + y);

        // swap variables without a temporary variable - not recommended!
        x = 5;
        y = 12;
        x = x ^ y;
        y = y ^ x;
        x = y ^ x;
        System.out.println("x = " + x + "; y = " + y);
        /*
        Like most "clever" code, that is far less clear and also it is slower.
         */
        // Rube Goldberg would approve, but don't ever do this!:
        x = 1984;
        y = 2001;
        y = (x ^= (y ^= x)) ^ y;
        System.out.println("x = " + x + "; y = " + y);
        // Do not assign to the same variable more than once in a single expression!
    }
}
