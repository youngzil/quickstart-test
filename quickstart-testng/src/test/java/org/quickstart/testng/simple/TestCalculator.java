package org.quickstart.testng.simple;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Georgy Gobozov on 12.01.2015.
 */
public class TestCalculator {

    Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        int result = calculator.sum(3, 2);
        Assert.assertEquals(5, result);
    }

    @Test
    public void testDiv() {
        int result = calculator.div(15, 3);
        Assert.assertEquals(5, result);
    }

    @Test
    public void testSub() {
        int result = calculator.sub(3, 2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testMult() {
        int result = calculator.mult(15, 3);
        Assert.assertEquals(25, result);
    }

}
