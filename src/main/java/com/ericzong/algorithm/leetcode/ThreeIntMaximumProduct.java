package com.ericzong.algorithm.leetcode;

import java.util.Arrays;

/**
 * #628
 * 来自力扣（LeetCode）
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 注意:
 * 给定的整型数组长度范围是[3,10^4]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * 解析：
 * 为了简化讨论，可以假设数组长度为 4，这样就可以分为以下 5 种情况：
 * 1. 4 个非负，0 个负
 * 2. 3 个非负，1 个负
 * 3. 2 个非负，2 个负
 * 4. 1 个非负，3 个负
 * 5. 0 个非负，4 个负
 * 对于情况 1，2 显然选择最大的 3 个非负整数。结果为非负；
 * 对于情况 3，4 显然选择最小的 2 个负整数和一个最大的非负整数。结果为非负；
 * 对于情况 5 显然选择最大的 3 个负整数。结果为负。
 * 总结下，情况 1，2，5 选择的都是 3 个最大的数，而情况 3，4 选择的是 2 个最小的和 1 个最大的。
 * 因此，只需要比较这两种选择哪种更大即可。
 */
public class ThreeIntMaximumProduct {
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 1] * nums[length - 2] * nums[length - 3]);
    }
}
