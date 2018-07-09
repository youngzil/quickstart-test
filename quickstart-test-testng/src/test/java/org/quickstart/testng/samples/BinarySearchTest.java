package org.quickstart.testng.samples;

import static org.testng.Assert.*;

import java.util.Arrays;

import org.testng.annotations.Test;

public class BinarySearchTest {

    @Test(dataProvider = "sortedArrays", dataProviderClass = BinarySearchDataProvider.class, groups = {"functional", "integration"})
    public void findValue(Integer[] sortedArray) {
        for (int index = 0; index < sortedArray.length; index++) {
            assertEquals(Arrays.binarySearch(sortedArray, sortedArray[index]), index);
        }
    }

    @Test(dataProvider = "sortedArrays", dataProviderClass = BinarySearchDataProvider.class, groups = {"functional"})
    public void findValue2(Integer[] sortedArray) {
        for (int index = 0; index < sortedArray.length; index++) {
            assertEquals(Arrays.binarySearch(sortedArray, sortedArray[index]), index);
        }
    }

}
