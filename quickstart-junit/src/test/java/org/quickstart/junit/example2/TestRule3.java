package org.quickstart.junit.example2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class TestRule3 {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void example() {
        collector.addError(new Throwable("first thing went wrong"));
        collector.addError(new Throwable("second thing went wrong"));
    }
}
