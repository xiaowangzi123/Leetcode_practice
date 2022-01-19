package com.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2022/1/19
 * @description: 复原 IP 地址
 */
public class Solution0093 {
    public static void main(String[] args) {
        Solution0093 obj = new Solution0093();
//        System.out.println(obj.restoreIpAddresses("abcde"));
        System.out.println(obj.restoreIpAddresses("25525511135"));
        System.out.println("----------------");
        String str = "123456";
        System.out.println(str.substring(0, 6));
        System.out.println(str.substring(1));

    }

    List<String> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n < 4 || n > 12) {
            return ans;
        }

        backtrack(0, 0, n, s, "");
        return ans;
    }


    /**
     *
     */
    public void backtrack(int index, int count, int n, String s, String sub) {
        if (index == s.length()) {
            if (count == 4) {
                ans.add(String.join(".", path));
            }
            return;
        }

        for (int i = index; i < index + 3 && i < n; i++) {
            String temp = s.substring(index, i + 1);
            path.add(temp);
            backtrack(i + 1, count + 1, n, s, s);
            path.remove(path.size() - 1);
        }
    }
}