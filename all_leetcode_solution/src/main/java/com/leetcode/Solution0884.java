package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0884 {
    public static void main(String[] args) {
        Solution0884 obj = new Solution0884();
        String A = "this apple is sweet", B = "this apple is sour";

        System.out.println(Arrays.toString(obj.uncommonFromSentences(A, B)));

    }

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] str = s1.split(" ");
        String[] str2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : str2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1){
                ans.add(entry.getKey());
            }
        }

        return ans.toArray(new String[0]);
    }


    //适合一般有规律的字符串，LeetCode不能通过
    public String mostCommonWord2(String paragraph, String[] banned) {
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