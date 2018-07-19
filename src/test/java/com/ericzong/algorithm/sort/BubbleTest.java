package com.ericzong.algorithm.sort;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public class BubbleTest {

    @Test
    public void testSortInteger() {
        test(getIntegerData());
    }

    @Test
    public void testSortInt() {
        test(getIntData());
    }

    @Test
    public void testSortObject() {
        test(getObjectData(), Data.getComparator());
    }

    private static void test(Comparable[] data) {
        System.out.println(data[0].getClass().getName());
        System.out.println("Before:" + Arrays.toString(data));
        Bubble.sort(data);
        System.out.println("After:" + Arrays.toString(data));

        for(int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(data[i].compareTo(data[i+1]) <= 0);
        }
    }

    private static void test(int[] data) {
        System.out.println(int.class.getName());
        System.out.println("Before:" + Arrays.toString(data));
        Bubble.sort(data);
        System.out.println("After:" + Arrays.toString(data));

        for(int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(Integer.compare(data[i], data[i + 1]) <= 0);
        }
    }

    private static void test(Object[] data, Comparator comparator) {
        System.out.println(data[0].getClass().getName());
        System.out.println("Before:" + Arrays.toString(data));
        Bubble.sort(data, comparator);
        System.out.println("After:" + Arrays.toString(data));

        for(int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(comparator.compare(data[i], data[i + 1]) <= 0);
        }
    }

    private static Integer[] getIntegerData() {
        RandomDataGenerator generator = new RandomDataGenerator();
        int[] ints = generator.nextPermutation(1000, 10);
        Integer[] data = new Integer[ints.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Integer(ints[i]);
        }

        return data;
    }

    private static int[] getIntData() {
        RandomDataGenerator generator = new RandomDataGenerator();
        int[] ints = generator.nextPermutation(1000, 10);
        return ints;
    }

    private static Data[] getObjectData() {
        RandomDataGenerator generator = new RandomDataGenerator();
        int[] ints = generator.nextPermutation(1000, 10);
        Data[] data = new Data[ints.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Data(ints[i]);
        }

        return data;
    }

    private static class Data {
        private int id;

        public Data(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id + "";
        }

        public static Comparator<Data> getComparator() {
            return new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    if(o1.id > o2.id) {
                        return 1;
                    } else if(o1.id < o2.id) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            };
        }
    }
}
