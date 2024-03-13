package com.leetcode.s2801_2900;

/**
 * 最大二进制奇数
 */
public class Solution2864 {
    public static void main(String[] args) {
        Solution2864 solution = new Solution2864();
        System.out.println(solution.maximumOddBinaryNumber("010"));
    }

    /**
     * 想要最终成奇数，最后一个数字必须是1
     * 统计1的个数为cnt1，应该有cnt1-1个1
     */
    public String maximumOddBinaryNumber(String s) {
        int cnt1 = (int) s.chars().filter(c -> c == '1').count();
        String s1 = repeatStr("1", cnt1 - 1);
        String s2 = repeatStr("0", s.length() - cnt1);
        return s1 + s2 + "1";
    }

    private String repeatStr(String str, int count) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }
}
