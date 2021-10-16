package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :最长连续递增序列
 */
public class Solution0682 {
    public static void main(String[] args) {
        Solution0682 obj = new Solution0682();
//        int[] arr = {1, 3, 5, 4, 7};
//        int[] arr = {2, 2, 2, 2, 2};
        int[] arr = {1,3,2};
        System.out.println(obj.findLengthOfLCIS(arr));
        System.out.println(obj.findLengthOfLCIS2(arr));
        System.out.println(obj.findLengthOfLCIS3(arr));
    }

    //改进参考方法3
    public int findLengthOfLCIS(int[] nums) {
        int count = 0, start = 0, index = 0, n = nums.length;
        while (index < n) {
            if (index > 0 && nums[index - 1] < nums[index]) {
                index++;
                count = Math.max(count, index - start);
            } else {
                index++;
                start = index;
            }
        }
        return count + 1;
    }

    public int findLengthOfLCIS2(int[] nums) {
        int count = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                index = i;
            }
            count = Math.max(count, i - index + 1);
        }
        return count;
    }

    public int findLengthOfLCIS3(int[] nums) {
        int count = 0, start = 0, index = 0, n = nums.length;
        while (index < n) {
            if (index > 0 && nums[index - 1] >= nums[index]) {
                start = index;
            }
            count = Math.max(count, index - start + 1);
            index++;

        }
        return count;
    }
}