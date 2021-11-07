package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 检查某单词是否等于两单词之和
 */
public class Solution1880 {
    public static void main(String[] args) {
        Solution1880 obj = new Solution1880();
        System.out.println(obj.isSumEqual("acb", "cba", "cdb"));

        System.out.println("acb".charAt(0) - 'a');
        System.out.println(obj.getNum("acb"));
        System.out.println(obj.getNum("cba"));
        System.out.println(obj.getNum("cdb"));
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getNum(firstWord) + getNum(secondWord) == getNum(targetWord);
    }

    public int getNum(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int temp = s.charAt(i) - 'a';
            ans += temp * Math.pow(10, s.length() - i - 1);
        }
        return ans;
    }
}