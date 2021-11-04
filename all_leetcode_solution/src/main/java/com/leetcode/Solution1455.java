package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/4
 * @description : 检查单词是否为句中其他单词的前缀
 */
public class Solution1455 {
    public static void main(String[] args) {
        Solution1455 obj = new Solution1455();
//        String sentence = "i love eating burger", searchWord = "burg";
        String sentence = "hellohello hellohellohello", searchWord = "ell";


        System.out.println(obj.isPrefixOfWord(sentence, searchWord));
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str = sentence.split(" +");
        for (int i = 0; i < str.length; i++) {
            int temp = str[i].indexOf(searchWord);
            if (temp == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}