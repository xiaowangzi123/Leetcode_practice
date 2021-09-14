package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/14
 * @description：
 */
public class Solution0217 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int[] arr2 = {1, 2, 3, 4};
        Solution0217 obj = new Solution0217();
        System.out.println(obj.containsDuplicate(arr));
        System.out.println(obj.containsDuplicate(arr2));

        System.out.println("-----------------------------");
        System.out.println(obj.containsDuplicate2(arr));
        System.out.println(obj.containsDuplicate2(arr2));

        System.out.println("-----------------------------");
        Set<Integer> set2 = new HashSet<>();
        System.out.println(set2.add(1));
        System.out.println(set2.add(1));
        
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++){
            if (nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

}