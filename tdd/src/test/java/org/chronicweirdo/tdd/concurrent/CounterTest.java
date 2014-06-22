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
}
