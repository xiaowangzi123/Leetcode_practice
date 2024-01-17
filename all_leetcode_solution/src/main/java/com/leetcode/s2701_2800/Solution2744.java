package com.leetcode.s2701_2800;

/**
 * 最大字符串匹配数目
 * 1 <= words.length <= 50
 * words[i].length == 2
 * words 包含的字符串互不相同。
 * words[i] 只包含小写英文字母。
 */
public class Solution2744 {
    public static void main(String[] args) {
        Solution2744 solution = new Solution2744();
        String[] word = new String[]{"cd", "ac", "dc", "ca", "zz"};
        System.out.println(solution.maximumNumberOfStringPairs(word));
    }

    /**
     * 动态规划求解
     */
    public int maximumNumberOfStringPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) {
                    res++;
                }
            }
        }
        return res;
    }
}
