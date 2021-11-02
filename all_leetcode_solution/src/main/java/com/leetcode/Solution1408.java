package com.leetcode;

import com.leetcode.bean.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/11/2
 * @description : 数组中的字符串匹配
 */
public class Solution1408 {
    public static void main(String[] args) {
        Solution1408 obj = new Solution1408();
//        String[] words = {"mass", "as", "hero", "superhero"};
        String[] words = {"leetcoder", "leetcode", "od", "hamlet", "am"};
        System.out.println(obj.stringMatching(words));
        System.out.println(obj.stringMatching2(words));

        System.out.println("--------------------------");
        System.out.println("ab".contains("abcd"));
        System.out.println("abcd".contains("ac"));
        System.out.println("abcd".indexOf("bc"));
        System.out.println("abcd".indexOf("ac"));
    }


    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < words.length; i++) {
                if (word.length() >= words[i].length()) {
                    continue;
                }
                if (words[i].contains(word)) {
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }

    public List<String> stringMatching2(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}