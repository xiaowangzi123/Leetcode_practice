package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description：
 */
public class Solution0219 {
    public static void main(String[] args) {
        Solution0219 obj = new Solution0219();
        int[] arr = {1, 2, 3, 1};
        System.out.println(obj.containsNearbyDuplicate(arr, 1));


        int[] arr2 = {1, 2, 3, 1,2,3};
        System.out.println(obj.containsNearbyDuplicate2(arr2, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j] && Math.abs(i-j)<=k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 思路
     * 标签：哈希
     * 维护一个哈希表，里面始终最多包含 k 个元素，当出现重复值时则说明在 k 距离内存在重复元素
     * 每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字
     * 时间复杂度：O(n)O(n)，nn 为数组长度
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(k);
        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size()>k){
                set.remove(i-k);
            }
        }
        return false;
    }
}