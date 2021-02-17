package org.quickstart.junit.example2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestRule6 {
    public static String log;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per
                                                        // method tested

    @Test
    public void testInfiniteLoop1() {
        log += "ran1";
        for (;;) {
        }
    }

    @Test
    public void testInfiniteLoop2() {
        log += "ran2";
        for (;;) {
        }
    }
}
