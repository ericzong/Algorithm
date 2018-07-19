package com.ericzong.algorithm.sort;

import com.ericzong.algorithm.sort.record.Data;
import com.ericzong.algorithm.sort.util.Utils;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public class BubbleTest {

    @Test
    public void testSortInteger() {
        Comparable[] data = Utils.getIntegerData();
        System.out.println(data[0].getClass().getName());
        System.out.println("Before:" + Arrays.toString(data));
        Bubble.sort(data);
        System.out.println("After:" + Arrays.toString(data));

        Utils.assertOrdered(data);
    }

    @Test
    public void testSortInt() {
        int[] data = Utils.getIntData();
        System.out.println(int.class.getName());
        System.out.println("Before:" + Arrays.toString(data));
        Bubble.sort(data);
        System.out.println("After:" + Arrays.toString(data));

        Utils.assertOrdered(data);
    }

    @Test
    public void testSortObject() {
        Object[] data = Utils.getObjectData();
        Comparator comparator = Data.getComparator();
        System.out.println(data[0].getClass().getName());
        System.out.println("Before:" + Arrays.toString(data));
        Bubble.sort(data, comparator);
        System.out.println("After:" + Arrays.toString(data));

        Utils.assertOrdered(data, comparator);
    }

}
