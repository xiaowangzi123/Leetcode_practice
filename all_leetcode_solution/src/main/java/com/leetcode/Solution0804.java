package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wyq
 * @create time: 2022/4/10
 * @description: 804. 唯一摩尔斯密码词
 */
public class Solution0804 {
    public static void main(String[] args) {
        Solution0804 obj = new Solution0804();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(obj.uniqueMorseRepresentations(words));
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] trans = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(trans[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }


}