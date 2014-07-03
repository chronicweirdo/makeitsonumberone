package org.chronicweirdo.javapuzzlers.chapter1.puzzle2;

import java.math.BigDecimal;

public class Change {
    public static void main(String args[]) {
        /*
        Rules for converting double values to strings: prints the shortest decimal fraction sufficient to distinguish
        the double value from its nearest neighbor. We expect 0.9. 1.1 can't be represented exactly as a double so it is
        represented by the closest double value. NOT ALL DECIMALS CAN BE REPRESENTED EXACTLY USING BINARY
        FLOATING-POINT. Binary floating-point is particularly ill-suited to monetary calculations - it can't represent
        any negative power of 10.
         */
        System.out.println("calculation using double: " + (2.00 - 1.10));
        /*
        Use integral type and make calculations in cents.
         */
        System.out.println("calculate using cents: " + (200 - 110) + " cents");
        /*
        Use BigDecimal (interoperates with the SQL DECIMAL type via JDBC). Always use the BigDecimal(String)
        constructor, NEVER the BigDecimal(double)!
         */
        System.out.println("BigDecimal(double) constructor: " + new BigDecimal(0.1));
        System.out.println("BigDecimal(String) constructor: " + new BigDecimal("0.1"));
        System.out.println("calculation using BigDecimal: " + new BigDecimal("2").subtract(new BigDecimal("1.1")));
    }
}
