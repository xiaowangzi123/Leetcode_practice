package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 反转单词前缀
 */
public class Solution2000 {
    public static void main(String[] args) {
        Solution2000 obj = new Solution2000();
        String word = "abcdefd";
        System.out.println(obj.reversePrefix(word, 'd'));
    }

    public String reversePrefix(String word, char ch) {
        char[] ans = word.toCharArray();
        int i = 0, j = word.indexOf(ch);
        while (i < j) {
            char temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }

        return new String(ans);
    }
}