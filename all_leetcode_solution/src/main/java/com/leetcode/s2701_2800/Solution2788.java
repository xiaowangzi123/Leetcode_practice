package com.leetcode.s2701_2800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按分隔符拆分字符串
 */
public class Solution2788 {
    public static void main(String[] args) {
        Solution2788 solution = new Solution2788();
        List<String> word = new ArrayList<>(Arrays.asList("one.two.three", "four.five", "six"));
        List<String> word2 = new ArrayList<>(Arrays.asList("$easy$","$problem$"));
//        System.out.println(solution.splitWordsBySeparator(word, '.'));
        System.out.println(solution.splitWordsBySeparator(word2, '$'));


    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word:words){
            res.addAll(getStrList(word, String.valueOf(separator)));
        }
        return res;
    }

    /**
     * separator分隔符中可能包含特殊字符，无法用split切分
     */
    public List<String> getStrList(String s, String separator) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        int index = s.indexOf(separator);
        List<String> res = new ArrayList<>();
        while (index != -1) {
            if (index != 0) {
                res.add(s.substring(0, index));
            }
            s = s.substring(index+separator.length());
            index = s.indexOf(separator);
        }
        if (!s.isEmpty()){
            res.add(s);
        }
        return res;
    }
}
