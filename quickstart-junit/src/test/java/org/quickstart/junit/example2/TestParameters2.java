package org.quickstart.junit.example2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestParameters2 {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}});
    }

    @Parameter(value = 0) // first data value (0) is default
    public /* NOT private */ int fInput;

    @Parameter(value = 1)
    public /* NOT private */ int fExpected;

    @Test
    public void test() {
        System.out.println(fExpected + "=" + fInput);
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
