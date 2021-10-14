package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :统计一致字符串的数目
 */
public class Solution1684 {
    public static void main(String[] args) {
        Solution1684 obj = new Solution1684();

        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(obj.countConsistentStrings(allowed, words));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }

        for (String word : words) {
            boolean flag = true;
            for (char ch:word.toCharArray()){
                if (!set.contains(ch)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                count++;
            }
        }

        return count;
    }
}