package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :最短补全词
 */
public class Solution0748 {
    public static void main(String[] args) {
        Solution0748 obj = new Solution0748();
       /* String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};*/
        //"pest"
//        String licensePlate = "1s3 456";
//        String[] words = {"looks", "pest", "stew", "show"};

        //"husband"
        String licensePlate = "Ah71752";
        String[] words = {"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"};

        System.out.println(obj.shortestCompletingWord(licensePlate, words));

        System.out.println(Character.isLetter('1'));
        System.out.println(Character.isLetter('A'));
        System.out.println(Character.isLetter(65));
        System.out.println(Character.isLowerCase('A'));
        System.out.println(Character.toLowerCase('A'));
    }

    /**
     *
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String ans = "";
        Map<Character, Integer> license = stringTomap(licensePlate);
        for (String word : words) {
            Map<Character, Integer> wordMap = stringTomap(word);
            boolean flag = compareWords(license, wordMap);
            if (flag) {
                if (ans.length() == 0) {
                    ans = word;
                } else {
                    ans = word.length() < ans.length() ? word : ans;
                }
            }
        }
        return ans;
    }

    public boolean compareWords(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
            if (map2.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public Map<Character, Integer> stringTomap(String st) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < st.length(); i++) {
            char ch = Character.toLowerCase(st.charAt(i));
            if (Character.isLetter(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        return map;
    }
}