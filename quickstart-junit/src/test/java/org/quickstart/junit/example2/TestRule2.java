package org.quickstart.junit.example2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class TestRule2 {

    @Rule
    public ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("server start");
        };

        @Override
        protected void after() {
            System.out.println("server stop");
        };
    };

    @Test
    public void testFoo() {
        System.out.println("server running");
    }
}
