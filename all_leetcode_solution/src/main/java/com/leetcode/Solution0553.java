package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/2/27
 * @description: 最优除法
 */
public class Solution0553 {
    public static void main(String[] args) {
        Solution0553 obj = new Solution0553();
        System.out.println(obj.optimalDivision(new int[]{1000, 100, 10, 2}));
    }

    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        for (int num : nums) {
            sb.append(num).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        if (n > 2) {
            sb.insert(sb.indexOf("/") + 1, "(");
            sb.append(")");
        }
        return sb.toString();
    }

}