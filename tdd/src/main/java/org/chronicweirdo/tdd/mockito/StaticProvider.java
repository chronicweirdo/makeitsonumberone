package org.chronicweirdo.tdd.mockito;

/**
 * Created by scacoveanu on 6/25/2014.
 */
public class StaticProvider {

    public static String provideMessage() {
        return "message " + System.currentTimeMillis();
    }
}
