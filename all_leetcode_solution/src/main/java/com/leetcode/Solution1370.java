package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :上升下降字符串
 */
public class Solution1370 {
    public static void main(String[] args) {
        Solution1370 obj = new Solution1370();
        String s = "aaaabbbbcccc";
        System.out.println(obj.sortString(s));


        System.out.println("-------------------------");
        StringBuilder ans = new StringBuilder(10);
        ans.append('a');
        ans.append((char) ('b' + 2));
        ans.append((char) (3 + 'b'));
        System.out.println(ans);
        System.out.println(ans.length());
        System.out.println(ans.capacity());
    }

    public String sortString(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder(n);
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        while (ans.length() < n) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    ans.append((char) (i + 'a'));
                    count[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    ans.append((char) (i + 'a'));
                    count[i]--;
                }
            }
        }
        return ans.toString();
    }
}