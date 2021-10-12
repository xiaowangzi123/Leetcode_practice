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
public class Solution1160 {
    public static void main(String[] args) {
        Solution1160 obj = new Solution1160();
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";

        System.out.println(obj.countCharacters(words, chars));
        System.out.println(obj.countCharacters2(words, chars));
    }

    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int[] res = new int[26];
        for (char ch : chars.toCharArray()) {
            res[ch - 'a']++;
        }

        for (int i = 0; i < words.length; i++) {
            int[] temp = new int[26];
            for (char ch : words[i].toCharArray()) {
                temp[ch - 'a']++;
            }

            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (temp[j] > res[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans += words[i].length();
            }
        }

        return ans;
    }

    public int countCharacters2(String[] words, String chars) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (char ch : words[i].toCharArray()) {
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            }
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
                if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans += words[i].length();
            }
        }

        return ans;
    }
}