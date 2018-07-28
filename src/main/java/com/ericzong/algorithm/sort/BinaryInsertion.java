package com.ericzong.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * @author  Eric Zong
 *
 * 折半插入排序
 * 算法逻辑：
 * 对直接插入排序的简单改进，算法逻辑与直接插入排序相似，区别仅在于查找插入位置的方法
 * 直接插入排序是顺序查找，而折半插入排序是折半查找，查找效率得以改进
 */
public class BinaryInsertion {

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
        if(length <= 1) return;

        for(int i = 1; i < length; i++) {
            if(isOrdered(data, i, comparator)) continue; // 有序，不需要插入

            insert(data, i, comparator);
        }
    }

    private static void insert(Object data, final int currentIdx, Comparator comparator) {
        int low = 0;
        int high = currentIdx - 1;
        Object current = Array.get(data, currentIdx);

        // 倒数第二次循环时，low = high = middleIdx
        // 最后一次赋值会导致 low > high
        while(low <= high) {
            int middleIdx = (low + high) / 2;
            Object middle = Array.get(data, middleIdx);
            if(isOrdered(middle, current, comparator)) {
                low = middleIdx + 1;
            } else {
                high = middleIdx - 1;
            }
        }

        // 将有序部分插入点后的元素向后移动一位
        for(int i = currentIdx; i > low; i--) {
            Object pre = Array.get(data, i - 1);
            Array.set(data, i, pre);
        }
        Array.set(data, low, current);
    }

    private static boolean isOrdered(Object data, int currentIdx, Comparator comparator) {
        Object first = Array.get(data, currentIdx - 1);
        Object last = Array.get(data, currentIdx);

        return isOrdered(first, last, comparator);
    }

    private static boolean isOrdered(Object first, Object last, Comparator comparator) {
        if(comparator != null) {
            return comparator.compare(first, last) <= 0;
        } else if(last instanceof Comparable) {
            return ((Comparable)first).compareTo(last) <= 0;
        }

        throw new RuntimeException("Uncomparable!");
    }
}
