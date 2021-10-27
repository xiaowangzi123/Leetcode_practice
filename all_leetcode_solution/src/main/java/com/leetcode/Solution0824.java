package com.leetcode;

import java.nio.channels.SeekableByteChannel;
import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/27
 * @description : 山羊拉丁文
 */
public class Solution0824 {
    public static void main(String[] args) {
        Solution0824 obj = new Solution0824();
        String s = "I speak Goat Latin";
        System.out.println(obj.toGoatLatin(s));
    }

    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            char ch = Character.toLowerCase(strs[i].charAt(0));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ans.append(strs[i]);
            } else {
                ans.append(strs[i].substring(1));
                ans.append(strs[i].charAt(0));
            }
            ans.append("ma");
            int count = i + 1;
            while (count > 0) {
                ans.append('a');
                count--;
            }
            if (i != strs.length - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}