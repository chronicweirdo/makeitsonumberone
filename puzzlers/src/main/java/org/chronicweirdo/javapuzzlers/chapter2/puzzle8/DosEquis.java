package org.chronicweirdo.javapuzzlers.chapter2.puzzle8;

public class DosEquis {
    public static void main(String[] args) {
        char x = 'X';
        int i = 0;
        System.out.print(true  ? x : 0);
        System.out.print(false ? i : x);
        /*
        Dark corner of the conditional operator specification sais:
        Mixed-type computation can be confusing; this is most apparent in conditional expressions.
        1. if the second and third operands have the same type, that is the type of the conditional expression
        2. if one of the operands is of type T (byte, short or char) and the other operand is a constant expression of
        type int whose value is representable in type T, the type of the conditional expression is T
        3. otherwise, binary numeric promotion is applied to the operand type
         */
    }
}
