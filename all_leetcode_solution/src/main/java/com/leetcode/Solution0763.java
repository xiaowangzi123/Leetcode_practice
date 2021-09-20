package com.leetcode;

import org.hamcrest.text.CharSequenceLength;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/20
 * @description：
 */
public class Solution0763 {
    public static void main(String[] args) {
        Solution0763 ojb = new Solution0763();
        String s = "ababcbacadefegdehijhklij";
        System.out.println(ojb.partitionLabels(s));
        System.out.println(ojb.partitionLabels2(s));
    }

    public List<Integer> partitionLabels(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, count[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

    public List<Integer> partitionLabels2(String s) {
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, s.lastIndexOf(s.charAt(i)));
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

}