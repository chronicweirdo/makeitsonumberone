package org.chronicweirdo.tdd.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Silviu on 6/22/14.
 */
public class SynchedThread extends Thread {

    private CyclicBarrier entryBarrier;
    private CyclicBarrier exitBarrier;

    public SynchedThread(Runnable runnable, CyclicBarrier entryBarrier, CyclicBarrier exitBarrier) {
        super(runnable);
        this.entryBarrier = entryBarrier;
        this.exitBarrier = exitBarrier;
    }

    @Override
    public void run() {
        try {
            entryBarrier.await();
            super.run();
            exitBarrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
