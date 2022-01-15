package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/1/15
 * @description: 1689. 十-二进制数的最少数目
 */
public class Solution1689 {
    public static void main(String[] args) {
        Solution1689 obj = new Solution1689();
        System.out.println(obj.minPartitions("32"));
        System.out.println(obj.minPartitions("8933735"));
    }

    public int minPartitions(String n) {
        int ans = 0;
        char[] chs = n.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int temp = chs[i] - '0';
            if (temp == 9) {
                return 9;
            } else {
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

}