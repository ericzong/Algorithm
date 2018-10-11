package com.ericzong.algorithm.sort;

import com.ericzong.algorithm.sort.util.SortUtils;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class HeapTest {
    @Test
    public void testSort() throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {
        SortUtils.testSort(Heap.class);
    }
}
