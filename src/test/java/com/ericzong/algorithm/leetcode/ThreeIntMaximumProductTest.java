package com.ericzong.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ThreeIntMaximumProductTest {
    private ThreeIntMaximumProduct instance;

    @BeforeTest
    public void setup() {
        instance = new ThreeIntMaximumProduct();
    }

    @DataProvider(name = "data")
    public Object[][] createData() {
        return new Object[][]{
                {new int[]{2, 5, 4, 3}, 60},
                {new int[]{-3, 5, 2, 4}, 40},
                {new int[]{-4, -3, 5, 2}, 60},
                {new int[]{3, -2, -5, -4}, 60},
                {new int[]{-5, -3, -2, -4}, -24}
        };
    }

    @Test(dataProvider = "data")
    public void testMaximumProduct(int[] nums, int max) {
        Assert.assertEquals(instance.maximumProduct(nums), max);
    }
}
