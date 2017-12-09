package com.ericzong.algorithm.number;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import com.ericzong.algorithm.number.TwoSumFull.Pair;

/**
 * @author Eric Zong
 */
@RunWith(Parameterized.class)
public class TwoSumFullTest {
    private int[] array;
    private int target;
    private String expected;

    public TwoSumFullTest(int[] array, int target, String expected) {
        super();
        this.array = array;
        this.target = target;
        this.expected = expected;
    }

    @Parameters
    public static Collection<?> params() {
        return Arrays.asList(new Object[][] {
            {new int[] { 10, 1, 5}, 10, "[]"}, 
            {new int[] { 1, 2, 3, 4, 8, 7, 10, 11 }, 10, "[<(1)2, (4)8>, <(2)3, (5)7>]"},
            {new int[] {5, 5, 5, 5}, 10, "[<(0)5, (1)5>, <(0)5, (2)5>, <(0)5, (3)5>, <(1)5, (2)5>, <(1)5, (3)5>, <(2)5, (3)5>]"},
            {new int[] {2, 8, 2, 8, 2, 8}, 10, "[<(0)2, (1)8>, <(0)2, (3)8>, <(0)2, (5)8>, <(1)8, (2)2>, <(2)2, (3)8>, <(2)2, (5)8>, <(1)8, (4)2>, <(3)8, (4)2>, <(4)2, (5)8>]"},
        });
    }

    @Test
    public void test() {
        Set<Pair> result = TwoSumFull.getPairByTarget(array, target);
        String resultString = Arrays.toString(result.toArray(new Pair[result.size()]));
        System.out.println(resultString);
        assertEquals(expected, resultString);
    }
}
