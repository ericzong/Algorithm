package com.ericzong.algorithm.number;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author Eric
 */
public class TwoSumSampleTest {
    @Test
    public void test() {
        int[] array = {5, 1, 3, 5, 9, 4, 6};
        int target = 10;
        
        int[] result = TwoSumSample.getPairByTarget(array, target);
        System.out.println(Arrays.toString(result));
    }
}
