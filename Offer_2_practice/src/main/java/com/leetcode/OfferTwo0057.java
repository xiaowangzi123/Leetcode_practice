package com.leetcode;

import java.util.TreeSet;

/**
 * @author: wyq
 * @create time: 2022/2/1
 * @description: 值和下标之差都在给定的范围内
 */
public class OfferTwo0057 {
    public static void main(String[] args) {
        OfferTwo0057 obj = new OfferTwo0057();
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1));
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }

    /**
     * 转换为long后，超时
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + k && j < n; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}