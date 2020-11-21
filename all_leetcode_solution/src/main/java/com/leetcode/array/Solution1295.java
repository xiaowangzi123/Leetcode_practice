package com.leetcode.array;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1295 {

    public static void main(String[] args) {
        Solution1295 obj = new Solution1295();
        int[] arr = {12, 345, 2, 6, 7896};
        System.out.println(obj.findNumbers(arr));
    }


    public int findNumbers(int[] nums) {
        int count = 0;
        int[] str = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            str[i] = String.valueOf(nums[i]).length();
            if (str[i]%2==0){
                count++;
            }
        }
        return count;
    }


}