package org.chronicweirdo.javapuzzlers.chapter5.puzzle_40;

/**
 * Created by Silviu on 8/31/14.
 */
public class Car2 {

    private static Class engineClass = Engine.class;

    private Engine engine = newEngine();

    private static Engine newEngine() {
        try {
            return (Engine) engineClass.newInstance();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e) {
            throw new AssertionError(e);
        }
    }

    public Car2() {
        // we are handling the exception in the static
        // initialization method of engine, so the
        // constructor does not have to throw the exceptions
        // anymore
    }
}
