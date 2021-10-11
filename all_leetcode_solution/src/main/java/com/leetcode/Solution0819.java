package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0819 {
    public static void main(String[] args) {
        Solution0819 obj = new Solution0819();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        System.out.println(obj.mostCommonWord(paragraph, banned));

        String regex = ",\\s+|\\s+|,|\\.";
//        String regex = "\\.|,|,\\s+|\\s+";
//        String regex = "([,][^(,\\\\s)])+";
        String[] strs = paragraph.split(regex);
        System.out.println(Arrays.toString(strs));

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(banned.length);
        for (String str : banned) {
            banSet.add(str);
        }

        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        //分割字符串
        String regex = ",\\s+|\\s+|,|\\.";
        String[] paras = paragraph.split(regex);
        for (String para : paras) {
            para = para.toLowerCase();
            if (para.length() != 0 && !banSet.contains(para)) {
                map.put(para, map.getOrDefault(para, 0) + 1);
                if (map.get(para) > count) {
                    ans = para;
                    count = map.get(para);
                }
            }
        }
        return ans;
    }
}