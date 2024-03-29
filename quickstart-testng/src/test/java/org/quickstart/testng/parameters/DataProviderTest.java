package org.quickstart.testng.parameters;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Georgy Gobozov on 12.01.2015.
 */
public class DataProviderTest {

    @Test(dataProvider = "provideNumbers")
    public void test(int number, int expected) {
        Assert.assertEquals(number + 10, expected);
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {

        return new Object[][] {{10, 20}, {100, 110}, {200, 210}};
    }

}
