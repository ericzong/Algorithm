package com.ericzong.algorithm.number;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题：给定一组整数，从中找出两个数，它们的和为指定目标整数。
 * 逻辑：先将数值放入 Map 中，后根据一数和目标计算出另一数，并通过 Map 快速查找数组中是否存在另一数。
 * 限制：
 *     1. 仅返回首个数对；
 *     2. 不能对重复数字进行匹配，比如：({1,3,5,5},10) 不能得到结果{5, 5} 
 * 
 * @author Eric
 */
public class TwoSumSample {

    public static int[] getPairByTarget(int[] array, int target) {
        Map<Integer, Integer> dataIndexMap = new HashMap<>(array.length);

        for (int i = 0; i < array.length; i++) {
            int data = array[i];
            if (!dataIndexMap.containsKey(data)) {
                dataIndexMap.put(data, i);
            }
        }

        for (int data : dataIndexMap.keySet()) {
            int other = target - data;
            if(data != other && dataIndexMap.containsKey(other)) {
                return new int[] {dataIndexMap.get(data), dataIndexMap.get(other)};
            }
        }

        return null;
    }

}
