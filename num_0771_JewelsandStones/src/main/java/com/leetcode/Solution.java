package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        String j = "aA", s = "aAASSS";
        System.out.println(obj.numJewelsInStones(j, s));
    }


    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }


}