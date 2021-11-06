package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description : 大重复子字符串
 */
public class Solution1668 {
    public static void main(String[] args) {
        Solution1668 obj = new Solution1668();
//        String sequence = "ababc", word = "ab";
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba";
//        "aaab aaaab aaaba aaaba aaaba aaaba aaaba"
//        "aaaba"
        System.out.println(obj.maxRepeating(sequence, word));
    }

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String temp = word;
        while (sequence.contains(word)) {
            count++;
            word += temp;
        }
        return count;
    }
}