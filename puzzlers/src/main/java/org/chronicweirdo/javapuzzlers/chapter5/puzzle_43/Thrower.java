package org.chronicweirdo.javapuzzlers.chapter5.puzzle_43;

public class Thrower {

    private static Throwable throwable;

    private Thrower() throws Throwable {
        throw throwable;
    }
    public static void main(String[] args) {
        sneakyThrow(new Exception("This is a checked exception"));
    }

    /*
     * Provide a body for this method to make it throw the specified exception.
     * You must not use any deprecated methods.
     */
    public static void sneakyThrow(Throwable t) {
        //throw (RuntimeException) t;
        throwable = t;
        try {
            Thrower.class.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException();
        } finally {
            throwable = null;
        }
    }
}
