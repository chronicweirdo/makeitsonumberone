package org.chronicweirdo.tdd.concurrent;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Silviu on 6/22/14.
 */
public class CounterTest {

    @Test
    public void testBasicFunctionality() throws Exception {
        Counter counter = new Counter();
        assertEquals(0, counter.value());
        counter.increment();
        assertEquals(1, counter.value());
        counter.increment();
        assertEquals(2, counter.value());
    }

    @Test
    public void testForThreadSafety() throws Exception {
        final Counter codeUnderTest = new Counter();
        final int numberOfThreads = 20;
        final int incrementsPerThread = 100;

        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < incrementsPerThread; i++) {
                    codeUnderTest.increment();
                }
            }
        };

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(runnable).start();
        }
        Thread.sleep(500);
        assertEquals(numberOfThreads * incrementsPerThread, codeUnderTest.value());
    }
}
