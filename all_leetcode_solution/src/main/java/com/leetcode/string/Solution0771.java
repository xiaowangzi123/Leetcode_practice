package com.leetcode.string;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution0771 {

    public static void main(String[] args) {
        Solution0771 obj = new Solution0771();
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