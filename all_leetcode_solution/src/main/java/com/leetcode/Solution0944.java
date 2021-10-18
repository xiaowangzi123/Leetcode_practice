package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/18
 * @description : 删列造序
 */
public class Solution0944 {
    public static void main(String[] args) {
        Solution0944 obj = new Solution0944();
//        String[] strs = {"abc", "bce", "cae"};
        String[] strs = {"zyx", "wvu", "tsr"};
        System.out.println(obj.minDeletionSize(strs));
    }

    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    count++;
                }
            }
        }
        return count;
    }
}