package org.chronicweirdo.junk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by Silviu on 06/06/2015.
 */
public class CutRod {

    private static int[] prices;

    private static class Sollution {
        int price = Integer.MIN_VALUE;
        int split1 = -1;
        int split2 = -1;
    }

    private static List<Sollution> sollutions = new ArrayList<>();
    static {
        for (int i = 0; i < 12; i++) {
            sollutions.add(null);
        }
    }

    private static int solve(int length) {
        // check if we have the sollution
        if (length == 0) {
            return 0;
        }
        if (sollutions.get(length) != null) {
            return sollutions.get(length).price;
        } else {
            // generate sollution by splitting
            Sollution sol = new Sollution();
            // initialise sollution with default sollutionj
            sol.price = prices[length];
            sol.split1 = 0;
            sol.split2 = length;
            sollutions.set(length, sol);
            // see if we can find a better sollution for this length
            for (int i = 1; i < length/2 + 1; i++) {
                int l1 = i;
                int l2 = length - i;
                int s1 = solve(l1);
                int s2 = solve(l2);
                if (s1 + s2 > sol.price) {
                    sol.price = s1 + s2;
                    sol.split1 = l1;
                    sol.split2 = l2;
                }
            }
            sollutions.set(length, sol);
            return sol.price;
        }
    }

    public static void main(String[] args) {
        System.out.println("cut your rod, sir?");

        prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(solve(4));
    }
}
