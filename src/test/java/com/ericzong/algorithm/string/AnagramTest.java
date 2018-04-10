package com.ericzong.algorithm.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AnagramTest {

    @Test
    public void testIsAnagramBySortFalseDiffLength() {
        String one = "short";
        String another = "longer";

        Assert.assertFalse(Anagram.isAnagramBySort(one, another));
    }

    @Test
    public void testIsAnagramBySortFalseSameLength() {
        String one = "mother";
        String another = "father";

        Assert.assertFalse(Anagram.isAnagramBySort(one, another));
    }

    @Test
    public void testIsAnagramBySortFalseSameWord() {
        String one = "same";
        String another = "Same";

        Assert.assertFalse(Anagram.isAnagramBySort(one, another));
    }

    @Test
    public void testIsAnagramBySortTrueConvertCase() {
        String one = "Unclear";
        String another = "Nuclear";

        Assert.assertTrue(Anagram.isAnagramBySort(one, another));
    }

    @Test
    public void testIsAnagramBySortTrue() {
        String one = "unclear";
        String another = "nuclear";

        Assert.assertTrue(Anagram.isAnagramBySort(one, another));
    }

    @Test
    public void testIsAnagramByStatisticFalseDiffLength() {
        String one = "short";
        String another = "longer";

        Assert.assertFalse(Anagram.isAnagramByStatistic(one, another));
    }

    @Test
    public void testIsAnagramByStatisticFalseSameLength() {
        String one = "mother";
        String another = "father";

        Assert.assertFalse(Anagram.isAnagramByStatistic(one, another));
    }

    @Test
    public void testIsAnagramByStatisticFalseSameWord() {
        String one = "same";
        String another = "Same";

        Assert.assertFalse(Anagram.isAnagramByStatistic(one, another));
    }

    @Test
    public void testIsAnagramByStatisticTrueConvertCase() {
        String one = "Unclear";
        String another = "Nuclear";

        Assert.assertTrue(Anagram.isAnagramByStatistic(one, another));
    }

    @Test
    public void testIsAnagramByStatisticTrue() {
        String one = "unclear";
        String another = "nuclear";

        Assert.assertTrue(Anagram.isAnagramByStatistic(one, another));
    }
}
