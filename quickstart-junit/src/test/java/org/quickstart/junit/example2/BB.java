package org.quickstart.junit.example2;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({SlowTests.class, FastTests.class})
public class BB {
    @Test
    public void c() {

    }
}
