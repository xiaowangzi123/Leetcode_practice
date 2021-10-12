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
}