package com.ericzong.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * @author Eric Zong
 *
 * 直接插入排序
 * 算法逻辑：
 * 依次将待排序的数据元素按其值的大小插入前面的有序序列
 * 第1趟插入：将第2个元素插入前面的有序子序列——此时前面只有一个元素，当然是有序的
 * 第2趟插入：将第3个元素插入前面的有序子序列，前面2个元素是有序的
 * ……
 * 第n-1趟插入：将第n个元素插入前面的有序子序列，前面n-1个元素是有序的
 */
public class Insertion {

    public static void sort(int[] data) {
        sortImpl(data, null);
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        sortImpl(data, null);
    }

    public static <E> void sort(E[] data, Comparator<E> comparator) {
        sortImpl(data, comparator);
    }

    private static void sortImpl(Object data, Comparator comparator) {
        int length = Array.getLength(data);
        if (length <= 1) return;

        for (int i = 1; i < length; i++) {
            Object insert = Array.get(data, i);
            for (int j = i - 1; j >= 0 && !isOrdered(Array.get(data, j), insert, comparator); j--) {
                Object current = Array.get(data, j);

                Array.set(data, j + 1, current);
                Array.set(data, j, insert);
            }
        }
    }

    private static boolean isOrdered(Object first, Object last, Comparator comparator) {
        if (comparator != null) {
            return comparator.compare(first, last) <= 0;
        } else if (last instanceof Comparable) {
            return ((Comparable) first).compareTo(last) <= 0;
        }

        throw new RuntimeException("Uncomparable!");
    }
}
