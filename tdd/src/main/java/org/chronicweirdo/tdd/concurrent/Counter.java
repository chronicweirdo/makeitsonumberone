package org.chronicweirdo.tdd.concurrent;

/**
 * Created by Silviu on 6/22/14.
 */
public class Counter {

    private long val;

    public void increment() {
        val++;
    }

    public long value() {
        return val;
    }
}
