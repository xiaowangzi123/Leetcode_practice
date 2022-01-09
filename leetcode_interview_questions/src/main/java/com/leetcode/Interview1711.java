package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2022/1/9
 * @description :
 */
public class Interview1711 {
    public static void main(String[] args) {
        Interview1711 obj = new Interview1711();
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        System.out.println(obj.findClosest(words, "a", "student"));
    }

    public int findClosest(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        int a1 = 0, a2 = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a1 = i;
            }
            if (words[i].equals(word2)) {
                a2 = i;
            }
            ans = Math.min(ans, Math.abs(a1 - a2));
        }
        return ans;
    }
}