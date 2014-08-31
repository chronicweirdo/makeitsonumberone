package org.chronicweirdo.javapuzzlers.chapter5.puzzle_39;

public class HelloGoodbye {
    public static void main(String[] args) {
        /*try {
            System.out.println("Hello world");
            System.exit(0);
        } finally {
            System.out.println("Goodbye world");
        }*/
        System.out.println("hello");
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    public void run() {
                        System.out.println("goodbye");
                    }
                }
        );
        System.exit(0);
    } 
}
