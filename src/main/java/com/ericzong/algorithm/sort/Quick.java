package com.ericzong.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * @author Eric Zong
 *
 * 快速插入排序
 * 算法逻辑：
 * 从待排序列任取一个元素作为分界值，所有比它小的元素放左边，比它大的元素放右边一趟排序后，
 * 原序列被分界元素分成 2 个子序列再对子序列递归重复上述过程，直至每个子序列只有一个元素
 *
 * 1. 一般使用 a[0] 作为分界元素
 * 2. 定义 i 变量，从 a[1] 查找大于分界的元素索引，用 i 记录
 * 3. 定义 j 变量，从 a[n-1] 查找小于分界的元素索引，用 j 记录
 * 4. 如 i < j ，交换 a[i]、a[j]
 * 5. 重复 2、3、4 直至 i >= j ，则 j 左边元素小于 a[0] ，右边大于 a[0]
 * 6. 将 a[0] 与 a[j]交换
 * 7. a[j] 将序列分为 2 个新序列，递归重复执行 2 ~ 6
 */
public class Quick {
    public static <E extends Comparable<E>> void sort(E[] data) {
        sortImpl(data, 0, data.length - 1, null);
    }

    public static void sort(int[] data) {
        sortImpl(data, 0, data.length - 1, null);
    }

    public static <E> void sort(E[] data, Comparator<E> comparator) {
        sortImpl(data, 0, data.length - 1, comparator);
    }

    private static void sortImpl(Object data, final int start, final int end, Comparator comparator) {
        if (start < end) {
            Object base = Array.get(data, start); // 以 start 元素作为分界值
            int low = start;    // 从 low + 1 开始
            int high = end + 1; // 从 high - 1 开始

            while (true) {
                // 移动到 low 端大值
                while (low < end && isOrdered(Array.get(data, ++low), base, comparator)) ;
                // 移动到 high 端小值
                while (high > start && isOrdered(base, Array.get(data, --high), comparator)) ;

                if (low < high) {
                    swap(data, low, high, comparator);
                } else {
                    break;
                }
            }

            swap(data, start, high, comparator); // 将分界值交换到“中部”

            sortImpl(data, start, high, comparator); // 递归 low 端
            sortImpl(data, high + 1, end, comparator); // 递归 high 端
        }
    }

    private static void swap(Object data, int i, int j, Comparator comparator) {
        if (!data.getClass().isArray()) {
            throw new RuntimeException(("Not Array"));
        }

        Object first = Array.get(data, i);
        Object second = Array.get(data, j);

        Array.set(data, i, second);
        Array.set(data, j, first);
    }

    private static boolean isOrdered(Object first, Object second, Comparator comparator) {
        if (comparator != null) {
            return comparator.compare(first, second) <= 0;
        } else if (first instanceof Comparable) {
            return ((Comparable) first).compareTo(second) <= 0;
        }

        throw new RuntimeException("Uncomparable!");
    }
}
