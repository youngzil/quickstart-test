package org.quickstart.junit.example2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class C {
    @Test
    public void testC() {
        System.out.println("C running");
        assertEquals("C", "C");
    }
}
