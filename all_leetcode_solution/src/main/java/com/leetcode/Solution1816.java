package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 截断句子
 */
public class Solution1816 {
    public static void main(String[] args) {
        Solution1816 obj = new Solution1816();
        String s = "Hello how are you Contestant";
        System.out.println(obj.truncateSentence(s, 40));
        System.out.println(obj.truncateSentence3(s, 40));
        int n = 1000000;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            obj.truncateSentence(s, 4);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        for (int i = 0; i < n; i++) {
            obj.truncateSentence3(s, 4);
        }
        long t3 = System.currentTimeMillis();
        System.out.println(t3 - t2);
        System.out.println(obj.truncateSentence2(s, 4));
    }

    public String truncateSentence(String s, int k) {
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k--;
                if (k == 0) {
                    break;
                }
            }
        }
        return s.substring(0, i);
    }

    public String truncateSentence2(String s, int k) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(str[i]);
            if (i != k - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    /**
     * k超过原有字符串的单词数时，截取的字符串为空
     */
    public String truncateSentence3(String s, int k) {
        int n = s.length();
        int end = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }
}