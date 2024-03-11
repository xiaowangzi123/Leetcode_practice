package com.leetcode.s2101_2200;


/**
 * 将标题首字母大写
 */
public class Solution2129 {

    public static void main(String[] args) {
        Solution2129 solution = new Solution2129();

        System.out.println(solution.capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(solution.capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(solution.capitalizeTitle("i lOve leetcode"));
    }

    public String capitalizeTitle(String title) {
        StringBuilder ans = new StringBuilder();
        for (String s : title.split(" ")) {
            if (s.length() > 2) {
                ans.append(s.substring(0, 1).toUpperCase());
                s = s.substring(1);
            }
            ans.append(s.toLowerCase()).append(" ");
        }
        return ans.toString().trim();
    }

}
