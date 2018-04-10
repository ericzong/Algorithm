package com.ericzong.algorithm.string;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * Anagram: 变位词，由颠倒字母顺序而构成的单词。如：unclear 和 nuclear。
 */
public class Anagram {



    public static boolean isAnagramBySort(String one, String another) {
        if (one.length() != another.length() || one.equalsIgnoreCase(another)) {
            return false;
        }

        String lowerCaseOne = one.toLowerCase();
        String lowerCaseAnother = another.toLowerCase();

        char[] charsOne = lowerCaseOne.toCharArray();
        char[] charsAnother = lowerCaseAnother.toCharArray();

        Arrays.sort(charsOne);
        Arrays.sort(charsAnother);

        return Arrays.equals(charsOne, charsAnother);
    }

    public static boolean isAnagramByStatistic(String one, String another) {
        if (one.length() != another.length() || one.equalsIgnoreCase(another)) {
            return false;
        }

        String lowerCaseOne = one.toLowerCase();
        String lowerCaseAnother = another.toLowerCase();

        char[] charsOne = lowerCaseOne.toCharArray();
        char[] charsAnother = lowerCaseAnother.toCharArray();

        Map<Character, Long> countOne = CharCounter.count(charsOne);
        Map<Character, Long> countAnother = CharCounter.count(charsAnother);

        return Objects.equals(countOne, countAnother);
    }

}
