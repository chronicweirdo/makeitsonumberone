package org.chronicweirdo.javapuzzlers.chapter3.puzzle12;

public class Abc {
    public static void main(String[] args) {
        String letters = "ABC";
        char[] numbers = { '1', '2', '3' };
        System.out.println(letters + " easy as " + numbers);
        // arrays inherit the toString method from Object
        System.out.println(letters + " easy as " + String.valueOf(numbers));

        System.out.print(letters + " easy as ");
        System.out.println(numbers);

        Object numbers2 = new char[] {'1', '2', '3'};
        System.out.print(letters + " easy as ");
        System.out.println(numbers2);
    }
}
