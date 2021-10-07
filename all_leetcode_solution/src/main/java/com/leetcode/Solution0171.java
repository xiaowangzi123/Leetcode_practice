package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/11
 * @description : Excel 表列序号
 * {@link Solution0168}
 */
public class Solution0171 {
    public static void main(String[] args) {
        Solution0171 obj = new Solution0171();
        System.out.println("Z/26==" + obj.titleToNumber("Z"));
        System.out.println("AB/28==" + obj.titleToNumber("AB"));
        System.out.println("AZ/52==" + obj.titleToNumber("AZ"));
        System.out.println("ZY/701==" + obj.titleToNumber("ZY"));
        System.out.println("AAA/703==" + obj.titleToNumber("AAA"));
        System.out.println("FXSHRXW/2147483647==" + obj.titleToNumber("FXSHRXW"));
        System.out.println("-----------------------------");

        System.out.println("Z/26==" + obj.titleToNumber2("Z"));
        System.out.println("AB/28==" + obj.titleToNumber2("AB"));
        System.out.println("AZ/52==" + obj.titleToNumber2("AZ"));
        System.out.println("ZY/701==" + obj.titleToNumber2("ZY"));
        System.out.println("AAA/703==" + obj.titleToNumber2("AAA"));
        System.out.println("FXSHRXW/2147483647==" + obj.titleToNumber2("FXSHRXW"));
        System.out.println("-----------------------------");

        System.out.println("Z/26==" + obj.titleToNumber3("Z"));
        System.out.println("AB/28==" + obj.titleToNumber3("AB"));
        System.out.println("AZ/52==" + obj.titleToNumber3("AZ"));
        System.out.println("ZY/701==" + obj.titleToNumber3("ZY"));
        System.out.println("AAA/703==" + obj.titleToNumber3("AAA"));
        System.out.println("FXSHRXW/2147483647==" + obj.titleToNumber3("FXSHRXW"));

        System.out.println('B' - 'A');
        System.out.println('Z' - 'A');
        System.out.println(Math.pow(26, 0));
        System.out.println(Math.pow(26, 2));
        System.out.println(26 * 26);
    }

    //

    /**
     * 类似26进制
     * “FXSHRXW” 中的每个字母对应的序号分别是：[6,24,19,8,18,24,23]，
     * 23*26^0+24*26^1+18*26^2+8*26^3+19*26^4+24*26^5+6*26^6 = 2147483647
     */
    public int titleToNumber(String columnTitle) {
        int ans = 0, mult = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int a = columnTitle.charAt(i) - 'A' + 1;
            ans += a * mult;
            mult *= 26;
        }
        return ans;
    }

    /**
     * Z:'Z'-'A'+1=26
     * AA:1*26+1=27
     * AZ:1*26+26=52
     * BA:2*26+1=53
     * ZA:26*26+1=677
     * ZY:26*26+25=701
     * AAA:1*26^2+1*26^1+1*26^0=703
     */
    public int titleToNumber2(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26 + (s.charAt(i) - 'A' + 1);
        }
        return sum;
    }

    //2147483647==-2147483076 越界
    public int titleToNumber3(String columnTitle) {
        int ans = 0, n = columnTitle.length();
        for (int i = n - 1; i >= 0; i--) {
            int a = columnTitle.charAt(i) - 'A' + 1;
            ans += a * Math.pow(26, n - i -1);
        }
        return ans;
    }
}