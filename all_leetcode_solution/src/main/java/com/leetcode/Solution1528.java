package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1528 {

    public static void main(String[] args) {
        Solution1528 obj = new Solution1528();
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(obj.restoreString(s, indices));
    }


    public String restoreString(String s, int[] indices) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < indices.length; j++) {
                if (i == indices[j]) {
                    res += s.charAt(j);
                }
            }
        }
        return res;
    }


}