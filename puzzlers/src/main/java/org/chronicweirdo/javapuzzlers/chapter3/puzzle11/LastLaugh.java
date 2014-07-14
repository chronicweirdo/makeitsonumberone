package org.chronicweirdo.javapuzzlers.chapter3.puzzle11;

public class LastLaugh {
    public static void main(String args[]) {
        System.out.print("H" + "a");
        System.out.print('H' + 'a');
        // force string concatenation
        System.out.print("" + 'H' + 'a');
        System.out.println("2 + 2 = " + 2 + 2);
        // or use printf
        System.out.printf("%c%c", 'H', 'a');
    }
}
