package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/2/1
 * @description: 值和下标之差都在给定的范围内
 */
public class OfferTwo0057 {
    public static void main(String[] args) {
        OfferTwo0057 obj = new OfferTwo0057();
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + k; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}