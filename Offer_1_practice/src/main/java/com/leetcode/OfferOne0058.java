package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/8
 * @description :
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class OfferOne0058 {
    public static void main(String[] args) {
        OfferOne0058 obj = new OfferOne0058();

        System.out.println(obj.reverseWords("  the sky is blue  "));
        System.out.println(obj.reverseWords2("th  bl  "));
        System.out.println("----------------------");
        System.out.println(obj.reverseLeftWords("abcdefg", 2));
        System.out.println(obj.reverseLeftWords2("abcdefg", 2));
        System.out.println("||" + " abc ".trim() + "||");
    }

    public String reverseWords(String s) {
        String[] st = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = st.length - 1; i >= 0; i--) {
            sb.append(st[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1, j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }

        return sb.toString().trim();
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 每次向左移动一次元素
     * 循环n次
     */
    public String reverseLeftWords2(String s, int n) {
        char[] ans = s.toCharArray();
        while (n > 0) {
            for (int i = 0; i < ans.length - 1; i++) {
                char temp = ans[i];
                ans[i] = ans[i + 1];
                ans[i + 1] = temp;
            }
            n--;
        }
        return new String(ans);
    }
}