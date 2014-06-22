package org.chronicweirdo.tdd.concurrent;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

/**
 * Created by Silviu on 6/22/14.
 */
public class BlockingTest {

    @Test
    public void testBlockingBehavior() throws Exception {
        final AtomicBoolean blocked = new AtomicBoolean(true);

        Thread buyer = new Thread() {
            @Override
            public void run() {
                /*try {
                    new BlackMarket().buyTicket();
                    blocked.set(false);
                } catch (InterruptedException expected) {
                }*/
            }
        };

        buyer.start();
        Thread.sleep(1000);
        buyer.interrupt();
        buyer.join(1000);

        assertFalse("Thread didn't interrupt!", buyer.isAlive());
        assertTrue("Method didn't block!", blocked.get());
    }


}
