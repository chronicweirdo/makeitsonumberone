package org.chronicweirdo.javapuzzlers.chapter2.puzzle10;

public class Tweedledee {
    public static void main(String[] args) {
        // Put your declarations for x and i here
        // my declarations - won't work, both are legal
        //String x = "one";
        //String i = "two";
        // my declarations - won't work, both are legal
        //String x = "one";
        //char i = 'c';
        // their sollution
        Object x = "Buy ";
        String i = "Effective Java!";

        x = x + i;  // Must be LEGAL
        //x += i;     // Must be ILLEGAL
    }
}
