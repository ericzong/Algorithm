package com.ericzong.algorithm.string;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CharCounterTest {
    @Test
    public void testCount() {
        String text = "test";
        Map<Character, Long> map = CharCounter.count(text);
        Map<Character, Long> expectedMap = new HashMap<Character, Long>() {
            {put('t', 2L); put('e', 1L); put('s', 1L);}
        };

        Assert.assertEquals(map, expectedMap);
    }
}
