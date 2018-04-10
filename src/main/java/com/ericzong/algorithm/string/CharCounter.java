package com.ericzong.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class CharCounter {


    public static Map<Character, Long> count(String text) {
        return count(text.toCharArray());
    }

    public static Map<Character, Long> count(char[] chars) {
        Map<Character, Long> map = new HashMap<>();

        for(char c : chars) {
            map.putIfAbsent(c, 0L);
            map.put(c, map.get(c) + 1);
        }

        return map;
    }
}
