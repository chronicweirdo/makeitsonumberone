package org.chronicweirdo.javapuzzlers.chapter3.puzzle13;

public class AnimalFarm {
    public static void main(String[] args) {
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();
        final String cat = "length: " + 10;

        System.out.println("Animals are equal: " + pig == dog);
        System.out.println("Animals are equal: " + pig == cat);
        // surprise MF! the + takes precedence over ==
        System.out.println("Animals are equal: " + (pig == dog));
        System.out.println("Animals are equal: " + (pig == cat));
        System.out.println("Animals are equal: " + pig.equals(dog));
    }
}
