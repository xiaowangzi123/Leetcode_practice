package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/14
 * @description : 检查数组是否经排序和轮转得到
 */
public class Solution1752 {
    public static void main(String[] args) {
        Solution1752 obj = new Solution1752();
//        int[] num = {3, 4, 5, 1, 2};
        int[] num = {2, 1, 3, 4};
//        int[] num = {1, 3, 1};
        System.out.println(obj.check(num));
//        int[] nums = {1,1,1};
        int[] nums = {3, 4, 3};
        System.out.println(obj.check2(nums));
    }

    public boolean check(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int count = 0, index = 0;
            while (nums[(i + index) % n] == arr[index]) {
                index++;
                count++;
                if (count == n) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check11(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int count = 0;
            //速度比上面的while慢
            for (int j = 0; j < n; j++) {
                if (nums[(i + j) % n] == arr[j]) {
                    count++;
                    if (count == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 1无变化，第一个元素不大于最后一个元素，flag=false
     * 2有翻转变化，第一个元素不小于最后一个元素 flag=true
     * 数组有相同元素，且首尾元素相同，flag=true
     * <p>
     * 遍历数组，第i个元素全部都不小于第i-1个，则表明数组非递减，返回true
     * 第i个元素小于第i-1个，说明数组有翻转过
     */
    public boolean check2(int[] nums) {
        int n = nums.length;
        boolean flag = nums[0] >= nums[n - 1];

        for (int i = 1; i < n; i++) {
            //nums[i] < nums[i - 1]表明数组翻转过，
            if (nums[i] < nums[i - 1]) {
                if (flag) {
                    //此时flag赋值false，表明只能出现一次nums[i] < nums[i - 1]
                    flag = false;
                } else {
                    //如果flag=false，与前面数组未变化矛盾，返回false
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 数组未变化时，不能出现一次nums[i] < nums[i - 1]
     * 数组有变化时，不能出现两次nums[i] < nums[i - 1]
     */
    public boolean check3(int[] nums) {
        int n = nums.length, count = 0;
        int limit = nums[0] >= nums[n - 1] ? 1 : 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > limit) {
                    return false;
                }
            }
        }
        return true;
    }
}