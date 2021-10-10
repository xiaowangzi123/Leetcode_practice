package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :
 */
public class Solution0448 {
    public static void main(String[] args) {
        Solution0448 obj = new Solution0448();
        //{5,6}
//        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        //{2}
//        int[] arr = {1, 1};
        //{}
        int[] arr = {1, 2};
        System.out.println(obj.findDisappearedNumbers(arr));
        System.out.println(obj.findDisappearedNumbers2(arr));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Arrays.sort(nums);
        int numMax = nums.length;
        for (int x = 1; x <= numMax; x++) {
            if (!list.contains(x)) {
                res.add(x);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        /*if (ans.size() == 0) {
            ans.add(set.last() + 1);
        }*/
        return ans;
    }
}