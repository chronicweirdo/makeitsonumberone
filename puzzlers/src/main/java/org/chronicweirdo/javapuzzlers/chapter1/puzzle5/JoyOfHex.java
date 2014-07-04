package org.chronicweirdo.javapuzzlers.chapter1.puzzle5;

public class JoyOfHex {
    public static void main(String[] args) {
        System.out.println(
            Long.toHexString(0x100000000L
                            + 0xcafebabe));
        System.out.println(
            Long.toHexString(0x100000000L
                           + 0x0cafebabe));
        /*
        Decimal literals are all positive, and you need to add a - sign in front to make them negative.
        Hex and octal literals are negative if their high-order bit is set. The number 0xcafebabe is an int constant
        with its high-order bit set, so it is negative.
        The performed addition is a mixed-type computation. The int is promoted to long and the conversion performs
        sign extension: promotes the negative int value to a numerically equal long value. It becomes
        0xffff_ffff_cafe_babeL. Add this to 0x0000_0001_0000_0000 and the negative part disappears.
         */

        System.out.println(
                Long.toHexString(0x100000000L
                        + 0x0cafebabeL));
    }
}
