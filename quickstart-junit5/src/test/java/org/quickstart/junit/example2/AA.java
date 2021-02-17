package org.quickstart.junit.example2;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.experimental.categories.Category;

class AA {
    @Category(SlowTests.class)
    @Test
    public void a() {
        System.out.println("AA.a");
        fail();
    }

    @Category(SlowTests.class)
    @Test
    public void b() {
        System.out.println("AA.b");
    }
}
