package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/30
 * @description : Bigram 分词
 */
public class Solution1078 {
    public static void main(String[] args) {
        Solution1078 obj = new Solution1078();
        String text = "alice is a  good girl she is a good student", first = "a", second = "good";
        System.out.println(Arrays.toString(obj.findOcurrences(text, first, second)));

    }

    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] str = text.split(" +");
        for (int i = 0; i < str.length - 2; i++) {
            if (str[i].equals(first) && str[i + 1].equals(second)) {
                list.add(str[i + 2]);
            }
        }
//        return list.toArray(new String[0]);
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}