package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/12
 * @description :
 */
public class Solution1002 {
    public static void main(String[] args) {
        Solution1002 obj = new Solution1002();
        String[] words = {"bella", "label", "roller"};

        System.out.println(obj.commonChars(words));
        System.out.println(obj.commonChars2(words));
    }

    public List<String> commonChars(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (char ch : words[0].toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (char ch : words[i].toCharArray()) {
                if (map.containsKey(ch)) {
                    temp.put(ch, temp.getOrDefault(ch, 0) + 1);
                }
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                map.put(entry.getKey(), Math.min(entry.getValue(), temp.getOrDefault(entry.getKey(), 0)));
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                for (int i = 0; i < entry.getValue(); i++) {
                    ans.add(entry.getKey().toString());
                }
            }
        }
        return ans;
    }

    public List<String> commonChars2(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] res = new int[26];
        for (char ch : words[0].toCharArray()) {
            res[ch - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] temp = new int[26];
            for (char ch : words[i].toCharArray()) {
                temp[ch - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                res[j] = Math.min(res[j], temp[j]);
            }
        }

        for (int i=0;i<26;i++){
            if (res[i]>0){
                for (int j=0;j<res[i];j++){
                    ans.add(String.valueOf((char)(i+'a')));
//                    ans.add((char)(i+'a')+"");
                }
            }
        }
        return ans;
    }
}