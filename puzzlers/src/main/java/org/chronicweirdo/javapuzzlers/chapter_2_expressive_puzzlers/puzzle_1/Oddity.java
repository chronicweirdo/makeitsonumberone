package org.chronicweirdo.javapuzzlers.chapter_2_expressive_puzzlers.puzzle_1;

public class Oddity {
    public static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    public static boolean isOddCorrect(int i) {
        return i % 2 != 0;
    }

    public static boolean isOddPerformance(int i) {
        return (i & 1) != 0;
    }

    public static void main(String[] args) {
        System.out.println("-2 is odd: " + isOdd(-2));
        System.out.println("-1 is odd: " + isOdd(-1));
        System.out.println("0 is odd: " + isOdd(0));
        System.out.println("1 is odd: " + isOdd(1));
        System.out.println("2 is odd: " + isOdd(2));
        System.out.println();
        // % operator is defined to satisfy the following identity for all int a and nonzero b:
        // (a / b) * b + (a % b) == a
        // (-1 / 2) * 2 + x == -1
        // 0 * 2 + x == -1
        // x == -1
        System.out.println("-2 is odd: " + isOddCorrect(-2));
        System.out.println("-1 is odd: " + isOddCorrect(-1));
        System.out.println("0 is odd: " + isOddCorrect(0));
        System.out.println("1 is odd: " + isOddCorrect(1));
        System.out.println("2 is odd: " + isOddCorrect(2));
        System.out.println();

        System.out.println("-2 is odd: " + isOddPerformance(-2));
        System.out.println("-1 is odd: " + isOddPerformance(-1));
        System.out.println("0 is odd: " + isOddPerformance(0));
        System.out.println("1 is odd: " + isOddPerformance(1));
        System.out.println("2 is odd: " + isOddPerformance(2));
        System.out.println();
    }
}
