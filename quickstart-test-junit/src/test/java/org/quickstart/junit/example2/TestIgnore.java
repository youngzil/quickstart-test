package org.quickstart.junit.example2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class TestIgnore {
    @Ignore("Test is ignored as a demonstration")
    @Test
    public void testSame() {
        assertThat(1, is(1));
    }

    @Test
    public void testAssertTrue() {
        assertTrue("failure - should be true", true);
    }
}
