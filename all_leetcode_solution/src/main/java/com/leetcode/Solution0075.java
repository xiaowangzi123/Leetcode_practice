package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description：
 */
public class Solution0075 {
    public static void main(String[] args) {
        Solution0075 obj = new Solution0075();
        int[] arr = {1, 2, 0, 2, 0, 1};
        obj.sortColors(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {1, 2, 0, 2, 0, 1};
        obj.sortColors2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        // 所以下面遍历到 0 的时候，先交换，再加
        int zero = 0;

        // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
        // 所以下面遍历到 2 的时候，先减，再交换
        int two = len;
        int i = 0;
        // 当 i == two 上面的三个子区间正好覆盖了全部数组
        // 因此，循环可以继续的条件是 i < two
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    /**
     * 两次循环
     * 第一次找出等于0的排在头部
     * 第二次找出等于1的排在0的后面
     */
    public void sortColors2(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, count);
                count++;
            }
        }
        for (int i = count; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, count);
                count++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}