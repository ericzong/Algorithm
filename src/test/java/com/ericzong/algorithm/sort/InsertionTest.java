package com.ericzong.algorithm.sort;

import com.ericzong.algorithm.sort.record.Data;
import com.ericzong.algorithm.sort.util.SortUtils;
import com.ericzong.algorithm.sort.util.Utils;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class InsertionTest {

    @Test
    public void testSort() throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {
        SortUtils.testSort(Insertion.class);
    }

}
