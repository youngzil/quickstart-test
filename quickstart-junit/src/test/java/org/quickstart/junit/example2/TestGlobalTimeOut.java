package org.quickstart.junit.example2;

import java.util.concurrent.CountDownLatch;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestGlobalTimeOut {
    public static String log;
    private final CountDownLatch latch = new CountDownLatch(1);

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

    @Test
    public void testSleepForTooLong() throws Exception {
        log += "ran1";
        Thread.sleep(100_000); // sleep for 100 seconds
    }

    @Test
    public void testBlockForever() throws Exception {
        log += "ran2";
        latch.await(); // will block
    }
}
