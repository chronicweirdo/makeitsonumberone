package org.chronicweirdo.javapuzzlers.chapter5.puzzle_40;

/**
 * Created by Silviu on 8/31/14.
 */
public class Car {

    private static Class engineClass = Engine.class;

    private Engine egine = (Engine) engineClass.newInstance();

    public Car() throws InstantiationException, IllegalAccessException{
        // constructor must throw all exceptions that can appear
        // in instance variables instantiation
    }
}
