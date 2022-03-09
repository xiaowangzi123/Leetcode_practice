package com.leetcode.todo;

/**
 * @author: wyq
 * @create time: 2022/3/9
 * @description: TODO
 * 得分最高的最小轮调
 */
public class Solution0798 {
    public static void main(String[] args) {
        Solution0798 obj = new Solution0798();
        System.out.println(obj.bestRotation(new int[]{2, 3, 1, 4, 0}));
        System.out.println(obj.bestRotation(new int[]{1, 3, 0, 2, 4}));
    }

    public int bestRotation(int[] nums) {
        //k
        int k = 0, n = nums.length, ans = 0;
        while (k < n) {
            for (int i = n - 1; i > 0; i--) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= i) {
                    max++;
                }
            }
            ans = Math.max(ans, max);
            k++;
        }
        return ans;
    }
}