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
        System.out.println(obj.restoreIpAddresses("25525511135"));


    }

    List<String> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n < 4 || n > 12) {
            return ans;
        }

        return ans;
    }


    /**
     *
     */
    public void backtrack(int index, int count, String s) {
        if (index == s.length()) {
            if (count == 0) {
                ans.add(String.join(".", path));
            }
            return;
        }

        for (int i = 1; i < s.length(); i++) {

        }
    }
}