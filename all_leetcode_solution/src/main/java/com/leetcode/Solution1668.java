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
        System.out.println(obj.maxRepeating2(sequence, word));
        System.out.println(obj.maxRepeating3(sequence, word));
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

    public int maxRepeating2(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }

    public int maxRepeating3(String sequence, String word) {
        int ans = 0, n = word.length();
        for (int k = 0; k < sequence.length(); k++) {
            int j = 0, count = 0;
            for (int i = k; i < sequence.length(); i++) {
                if (sequence.charAt(i) == word.charAt(j++ % n)) {
                    count++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, count / n);
        }
        return ans;
    }

}