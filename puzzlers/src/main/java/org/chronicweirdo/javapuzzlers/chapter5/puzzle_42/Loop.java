package org.chronicweirdo.javapuzzlers.chapter5.puzzle_42;

public class Loop {
    public static void main(String[] args) {
        int[][] tests = { { 6, 5, 4, 3, 2, 1 }, { 1, 2 },
                          { 1, 2, 3 }, { 1, 2, 3, 4 }, { 1 } };
        int n = 0;

        try {
            int i = 0;
            while (true) {
                System.out.println(i);
                if (thirdElementIsThree(tests[i++]))
                    n++;
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            // No more tests to process
            System.out.println("index out of bounds");
        }
        System.out.println(n);
    }

    private static boolean thirdElementIsThree(int[] a) {
        //return a.length >= 3 & a[2] == 3;
        return a.length >= 3 && a[2] == 3; // this works
    }
}
