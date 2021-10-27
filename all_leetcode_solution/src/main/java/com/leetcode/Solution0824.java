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
                strs[i] += "ma";
            } else {
                strs[i] = strs[i].substring(1) + strs[i].charAt(0) + "ma";
            }
            ans.append(strs[i]);
            int count = i + 1;
            while (count > 0) {
                ans.append('a');
                count--;
            }
            if (i!=strs.length-1){
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}