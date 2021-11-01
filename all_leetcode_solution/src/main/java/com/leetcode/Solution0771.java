package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description : 宝石与石头
 */
public class Solution0771 {
    public static void main(String[] args) {
        Solution0771 obj = new Solution0771();
        String j = "aA", s = "aAASSS";
        System.out.println(obj.numJewelsInStones(j, s));
    }


    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            }
        }
        return count;
    }

}