package com.ericzong.algorithm.sort.util;

import com.ericzong.algorithm.sort.record.Data;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.testng.Assert;

import java.util.Comparator;

public class Utils {
    public static Integer[] getIntegerData() {
        RandomDataGenerator generator = new RandomDataGenerator();
        int[] ints = generator.nextPermutation(1000, 10);
        Integer[] data = new Integer[ints.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Integer(ints[i]);
        }

        return data;
    }

    public static int[] getIntData() {
        RandomDataGenerator generator = new RandomDataGenerator();
        int[] ints = generator.nextPermutation(1000, 10);
        return ints;
    }

    public static Data[] getObjectData() {
        RandomDataGenerator generator = new RandomDataGenerator();
        int[] ints = generator.nextPermutation(1000, 10);
        Data[] data = new Data[ints.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Data(ints[i]);
        }

        return data;
    }

    public static void assertOrdered(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(Integer.compare(data[i], data[i + 1]) <= 0,
                    "Ordered expected but disordered.");
        }
    }

    public static void assertOrdered(Comparable[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(data[i].compareTo(data[i + 1]) <= 0,
                    "Ordered expected but disordered.");
        }
    }

    public static void assertOrdered(Object[] data, Comparator comparator) {
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(comparator.compare(data[i], data[i + 1]) <= 0,
                    "Ordered expected but disordered.");
        }
    }
}
