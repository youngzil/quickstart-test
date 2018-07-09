package org.quickstart.testng.samples;

import org.testng.annotations.DataProvider;

public class BinarySearchDataProvider {

    @DataProvider(name = "sortedArrays")
    public static Object[][] sortedArrays() {
        return new Object[][] {new Integer[] {1, 2, 3, 4, 5}, new Integer[] {2, 4, 5, 7}, new Integer[] {4, 6, 7, 8}};
    }
}
