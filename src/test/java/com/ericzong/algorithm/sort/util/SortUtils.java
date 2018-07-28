package com.ericzong.algorithm.sort.util;

import com.ericzong.algorithm.sort.record.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class SortUtils {
    public static final String SORT_METHOD = "sort";

    public static void testSort(Class sortClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testSortInt(sortClass);
        testSortInteger(sortClass);
        testSortObject(sortClass);
    }

    private static void testSortInt(Class sortClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = sortClass.getMethod(SORT_METHOD, int[].class);
        int[] data = Utils.getIntData();

        System.out.println(int.class.getName());
        System.out.println("Before:" + Arrays.toString(data));

        method.invoke(null, data);

        System.out.println("After:" + Arrays.toString(data));

        Utils.assertOrdered(data);
    }

    private static void testSortInteger(Class sortClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = sortClass.getMethod(SORT_METHOD, Comparable[].class);
        Integer[] data = Utils.getIntegerData();

        System.out.println(data[0].getClass().getName());
        System.out.println("Before:" + Arrays.toString(data));

        method.invoke(null, new Object[] { data });

        System.out.println("After:" + Arrays.toString(data));

        Utils.assertOrdered(data);
    }

    private static void testSortObject(Class sortClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = sortClass.getMethod(SORT_METHOD, Object[].class, Comparator.class);
        Comparator<Data> comparator = Data.getComparator();
        Object[] data = Utils.getObjectData();

        System.out.println(data[0].getClass().getName());
        System.out.println("Before:" + Arrays.toString(data));

        method.invoke(null, data, comparator);

        System.out.println("After:" + Arrays.toString(data));

        Utils.assertOrdered(data, comparator);
    }
}
