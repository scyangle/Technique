package com.scy;

/**
 * Created by Shichengyao on 4/17/17.
 */

/**
 *  请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
 给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
 测试样例：
 [9,3,1,10],4
 return 6
 */
public class GetMaxGapConsecutiveNumbers {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 4, 5, -10};
        System.out.println(maxGap1(arr));
    }

    public static int getBuckPosition(Integer arr, int len, int min, int max) {
        return (arr - min) * len / (max - min);
    }

    public static Integer maxGap1(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Integer min = nums[0];
        Integer max = nums[0];
        for (Integer temp : nums) {
            min = Math.min(temp, min);
            max = Math.max(temp, max);
        }
        if (min == max) {
            return 0;
        }
        Integer[] mins = new Integer[nums.length + 1];
        Integer[] maxs = new Integer[nums.length + 1];
        boolean[] hasNum = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int bid = getBuckPosition(nums[i], nums.length, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int i = 0;
        int lastMax = 0;
        while (i <= nums.length) {
            if (hasNum[i++]) {
                lastMax = maxs[i - 1];
                break;
            }
        }
        int maxGap = 0;
        for (; i <= nums.length; i++) {
            if (hasNum[i]) {
                maxGap = Math.max(maxGap, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return maxGap;
    }

    public static Integer maxGap2(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Integer min = nums[0];
        Integer max = nums[0];
        for (Integer temp : nums) {
            min = temp < min ? temp : min;
            max = temp > max ? temp : max;
        }
        Integer[] buckets = new Integer[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] - min] = 1;
        }
        int maxGap = 0;
        int count = 0;
        for (Integer temp : buckets) {
            if (temp == null) {
                count++;
            } else {
                maxGap = maxGap > count ? maxGap : count;
                count = 0;
            }
        }
        return maxGap + 1;
    }
}
