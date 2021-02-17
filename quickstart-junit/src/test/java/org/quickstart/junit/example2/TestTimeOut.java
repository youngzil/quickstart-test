package org.quickstart.junit.example2;

import org.junit.Test;

public class TestTimeOut {
    @Test(timeout = 10000)
    public void testWithTimeout() {
        while (true) {
        }
    }
}
