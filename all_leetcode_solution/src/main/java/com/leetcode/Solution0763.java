package com.leetcode;

import org.hamcrest.text.CharSequenceLength;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(ojb.partitionLabels3(s));
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

    /**
     * 1.找出每个子序列中，第一个字母最后出现位置的索引end
     * 2.遍历start到end位置中的每一个字母，找出此字母最后出现位置的索引
     * 此索引大于end，替换当前end值
     * 3.当i==end时，表明第一个要找的子序列结束，记录此时的end值
     * 然后从当前位置的后一位开始计算start
     */
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

    public List<Integer> partitionLabels3(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

}