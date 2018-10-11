package com.ericzong.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * 基本概念：
 * 该算法利用堆这种数据结构进行排序。
 * 堆总是一个完全二叉树，并且每个节点与其子节点间都具有相同的比较关系。
 *
 * 算法逻辑：
 * 1. 将无序数据构建成堆；
 * 2. 将堆顶（即首个元素）与无序数据末尾元素互换，使末尾元素之后有序；
 * 3. 以些类推，直至无序数据为空。
 *
 * 备注：
 * 堆排序在”筛选“无序区中最大节点的过程中依赖了堆的特性，好处是”筛选“后仅需调整部分节点即可重构堆，
 * 而不需要完全从头构建，这大大提升了性能。
 * 大部分带有类似”筛选“操作的排序算法都没有保存上一次比较有序性的能力。
 */
public class Heap {

    public static <E extends Comparable<E>> void sort(E[] data) {
        sortImpl(data, null);
    }

    public static void sort(int[] data) {
        sortImpl(data, null);
    }

    public static <E> void sort(E[] data, Comparator<E> comparator) {
        sortImpl(data, comparator);
    }

    private static void sortImpl(Object data, Comparator comparator) {
        int length = Array.getLength(data);

        // 自底而上调整所有节点以构建堆。
        // 技巧点：由于以叶子节点为根的子树已是堆，所以从最后一个非叶子节点开始调整即可。
        for(int i = getLastNotLeafIdx(length); i >= 0; i--) {
            heapAdjust(data, i, length - 1, comparator);
        }

        for(int j = length - 1; j >= 1; j--) {
            // 堆顶为所有堆元素中最大的，换至无序区末尾（即有序区开头）
            swap(data, 0, j);
            // 互换后无序区不再是堆，重建堆
            heapAdjust(data, 0, j - 1, comparator);
        }
    }

    /**
     * 调整完全二叉树为堆，该二叉树的根节点索引为topIdx，节点最大索引为maxIdx。
     *
     * ”筛选“算法逻辑：
     * 1. 查看被调整节点的左右子节点：将子节点中最大的节点与其互换；否则完结
     * 2. 对互换后的调整节点继续重复上一步操作，直至没有子节点为止
     */
    private static void heapAdjust(Object data, int topIdx, int maxIdx, Comparator comparator) {
        Object current = Array.get(data, topIdx);
        int adjustIdx = topIdx; // 调整节点的索引，开始为topIdx，调整时可能会逐渐”下移“

        for (int i = getLeftChildIdx(adjustIdx); i <= maxIdx; i = getLeftChildIdx(adjustIdx)) {
            int largerIdx = i;
            if (hasRightChild(adjustIdx, maxIdx)) {
                largerIdx = getLargerIdx(data, i, i + 1, comparator);
            }

            if(isLarger(current, Array.get(data, largerIdx), comparator)) {
                break;
            } else {
                // 调整节点与较大的子节点互换
                // 技巧点：这里并没有互换，只是把原子节点换上来了，原父节点没有换下去，因为这不是必须的，
                //        current 中保存了该节点，可直接取用
                Array.set(data, adjustIdx, Array.get(data, largerIdx));
                adjustIdx = largerIdx;
            }
        }

        // 将原调整节点赋值到最终位置
        Array.set(data, adjustIdx, current);
    }

    private static int getLargerIdx(Object data, int i, int j, Comparator comparator) {
        return isLarger(data, i, j, comparator) ? i : j;
    }

    private static boolean isLarger(Object first, Object second, Comparator comparator) {
        if(comparator != null ) {
            return comparator.compare(first, second) > 0;
        } else if (first instanceof Comparable) {
            return ((Comparable)first).compareTo(second) > 0;
        }

        throw new RuntimeException("Uncomparable");
    }

    private static boolean isLarger(Object data, int i, int j, Comparator comparator) {
        if (!data.getClass().isArray()) {
            throw new RuntimeException("Not Array");
        }

        Object first = Array.get(data, i);
        Object second = Array.get(data, j);

        return isLarger(first, second, comparator);
    }

    private static void swap(Object data, int i, int j) {
        if (!data.getClass().isArray()) {
            throw new RuntimeException("Not Array");
        }

        Object first = Array.get(data, i);
        Object second = Array.get(data, j);

        Array.set(data, i, second);
        Array.set(data, j, first);
    }

    /**
     * maxIdx 在构建堆时，总是数据的长度 - 1；在排序过程中，总是未排序数据节点的长度 - 1
     */
    private static boolean hasRightChild(int parentIdx, int maxIdx) {
        return getRightChildIdx(parentIdx) <= maxIdx;
    }

    /**
     * 根据完全二叉树某节点索引计算其理论da 子节点索引
     */
    private static int getLeftChildIdx(int parentIdx) {
        return (parentIdx << 1) + 1;
    }

    /**
     * 根据完全二叉树某节点索引计算其理论右子节点索引
     */
    private static int getRightChildIdx(int parentIdx) {
        return (parentIdx << 1) + 2;
    }

    /**
     * 对于完全二叉树而言，最后一个非叶子节点其实就是最后一个节点的父节点
     */
    private static int getLastNotLeafIdx(int n) {
        return getParentIdx(n - 1);
    }

    /**
     * 根据完全二叉树某节点索引计算其父节点索引
     */
    private static int getParentIdx(int childIdx) {
        return (childIdx - 1) >> 1;
    }
}
