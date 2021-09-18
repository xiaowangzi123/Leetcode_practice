package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/18
 * @description：
 */
public class Solution0334 {
    public static void main(String[] args) {
        Solution0334 obj = new Solution0334();
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {2, 1, 5, 0, 4, 6};

//        System.out.println(obj.increasingTriplet(arr2));
        System.out.println(obj.increasingTriplet(arr3));
        System.out.println((int) Math.pow(2, 31) == Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 31));
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * {2,1,5,0,4,6}
     * 1.先找出符合条件的不完整序列，{2,5}最小值2，中间值5
     * 2.后面有值比mid值大，存在有序数列，返回true
     *   后面有值比min值小，替换min值{0,5}
     *   后面有值比min大，比mid小，替换mid值{0,4}
     * 4.一直找出{0,4,6}，找出较小的替换大的，不影响要找的从小到大序列
     * {0,4,6}替换了{2,5,6}
     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else if (nums[i] > mid) {
                return true;
            }
        }
        return false;
    }
}