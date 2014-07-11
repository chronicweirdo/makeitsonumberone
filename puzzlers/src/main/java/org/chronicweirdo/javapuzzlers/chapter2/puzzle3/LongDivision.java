package org.chronicweirdo.javapuzzlers.chapter2.puzzle3;

public class LongDivision {
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        /*
        Even if result is stored in long, the computation is done in int and it overflows.
        Java does not have target typing (which means type of var where result is stored influences the computation).
         */
        final long MICROS_PER_DAY_2 = 24l * 60l * 60l * 1000l * 1000l;
        final long MILLIS_PER_DAY_2 = 24l * 60l * 60l * 1000l;
        System.out.println(MICROS_PER_DAY_2 / MILLIS_PER_DAY_2);
    }
}
