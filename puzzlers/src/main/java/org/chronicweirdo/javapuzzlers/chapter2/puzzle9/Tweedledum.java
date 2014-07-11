package org.chronicweirdo.javapuzzlers.chapter2.puzzle9;

public class Tweedledum {
    public static void main(String[] args) {
        // Put your declarations for x and i here
        // my original declarations - a good sollution
        //char x = 0;
        //int i = 4;
        // their sollution
        short x = 0;
        int i = 123456;


        x += i;     // Must be LEGAL - result will be -7616! overflows, has implicit (hidden, silent) cast
        //x = x + i;  // Must be ILLEGAL - won't compile, possible loss of precision, needs explicit cast to compile

        /*
        Compound assignment expressions automatically cast the result of the computation they perform to the type
        of the variable on their left-hand side. If the type of the result is identical to the type of the variable,
        the cast has no effect; if the type of the result is wider than that of the variable, the compound assignment
        operator performs a silent narrowing primitive conversion -> compilation error.

        Compound assignment expressions can be dangerous, do not use them with variables of type byte, short or char.
         */
    }
}
