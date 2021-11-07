package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 将句子排序
 */
public class Solution1859 {
    public static void main(String[] args) {
        Solution1859 obj = new Solution1859();
        System.out.println(obj.sortSentence("is2 sentence4 This1 a3"));
    }

    public String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] arr = new String[str.length];
        for (String st : str) {
            arr[st.charAt(st.length() - 1) - '1'] = st.substring(0, st.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}