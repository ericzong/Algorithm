package com.ericzong.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * 算法逻辑：<br/>
 *    1：从a[0]-a[N-1]中选出最小的数据，然后与a[0]交换位置<br/>
 *    2：从a[1]-a[N-1]中选出最小的数据，然后与a[1]交换位置（第1步结束后a[0]就是N个数的最小值）<br/>
 *    3：从a[2]-a[N-1]中选出最小的数据，然后与a[2]交换位置（第2步结束后a[1]就是N-1个数的最小值）<br/>
 *    以此类推，N-1次排序后，待排数据就已经按照从小到大的顺序排列了。<br/>
 */
public class StraightSelect {

    public static void sort(int[] data) {
        sortImpl(data, null);
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        sortImpl(data, null);
    }

    public static <E> void sort(E[] data, Comparator comparator) {
        sortImpl(data, comparator);
    }

    private static void sortImpl(Object data, Comparator comparator) {
        int length = Array.getLength(data);
        if(length <= 1) return;

        for (int i = 0; i < length; i++) {
            int minIdx = i;

            for(int j = i + 1; j < length; j++) {
                Object min = Array.get(data, minIdx);
                Object current = Array.get(data, j);
                if(!isOrdered(min, current, comparator)) {
                    minIdx = j;
                }
            }

            swap(data, i, minIdx);
        }
    }

    private static void swap(Object data, int i, int j) {
        if(i == j) return;

        Object first = Array.get(data, i);
        Object second = Array.get(data, j);

        Array.set(data, i, second);
        Array.set(data, j, first);
    }

    private static boolean isOrdered(Object first, Object last, Comparator comparator) {
        if (comparator != null) {
            return comparator.compare(first, last) < 0;
        } else if (last instanceof Comparable) {
            return ((Comparable) first).compareTo(last) < 0;
        }

        throw new RuntimeException("Uncomparable!");
    }
}
