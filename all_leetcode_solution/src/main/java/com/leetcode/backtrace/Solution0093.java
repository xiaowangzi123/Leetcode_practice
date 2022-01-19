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
//        System.out.println(obj.restoreIpAddresses("012345678"));
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

        backtrack(0, 0, n, s);
        return ans;
    }

    public void backtrack(int index, int count, int n, String s) {
        if (index == s.length()) {
            if (count == 4) {
                ans.add(String.join(".", path));
            }
            return;
        } else if (count > 4) {
            return;
        }

        for (int i = index; i < index + 3 && i < n; i++) {
            if (count == 4) {
                break;
            }
            String temp = s.substring(index, i + 1);
            if (!checkIp(temp)) {
                continue;
            }
            path.add(temp);
            backtrack(i + 1, count + 1, n, s);
            path.remove(path.size() - 1);
        }
    }

    public boolean checkIp(String ip) {
        int len = ip.length();
        if (len > 1 && ip.charAt(0) == '0') {
            return false;
        }
        int res = Integer.valueOf(ip);
        return res >= 0 && res <= 255;
    }
}