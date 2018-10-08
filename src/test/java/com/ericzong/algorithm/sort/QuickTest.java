package com.ericzong.algorithm.sort;

import com.ericzong.algorithm.sort.util.SortUtils;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class QuickTest {

    @Test
    public void testSort() throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {
        SortUtils.testSort(Quick.class);
    }
}
