package com.ericzong.algorithm.sort;

import com.ericzong.algorithm.sort.record.Data;
import com.ericzong.algorithm.sort.util.Utils;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionTest {

    @Test
    public void testSortInt() {
        int[] data = Utils.getIntData();
        System.out.println(int.class.getName());
        System.out.println("Before:" + Arrays.toString(data));
        Insertion.sort(data);
        System.out.println("After:" + Arrays.toString(data));

        Utils.assertOrdered(data);
    }

    @Test
    public void testSortInteger() {
        Integer[] data = Utils.getIntegerData();
        System.out.println(data[0].getClass().getName());
        System.out.println("Before:" + Arrays.toString(data));
        Insertion.sort(data);
        System.out.println("After:" + Arrays.toString(data));

        Utils.assertOrdered(data);
    }

    @Test
    public void testSortObject() {
        Data[] data = Utils.getObjectData();
        Comparator<Data> comparator = Data.getComparator();
        System.out.println(data[0].getClass().getName());
        System.out.println("Before:" + Arrays.toString(data));
        Insertion.sort(data, comparator);
        System.out.println("After:" + Arrays.toString(data));

        Utils.assertOrdered(data, comparator);
    }
}
