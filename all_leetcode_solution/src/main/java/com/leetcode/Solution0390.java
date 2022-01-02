package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyq
 * @create time: 2022/1/2
 * @description: 消除游戏
 */
public class Solution0390 {
    public static void main(String[] args) {
        Solution0390 obj = new Solution0390();
        System.out.println(obj.lastRemaining(9));
    }

    public int lastRemaining(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        boolean flag = true;
        while (sb.length() > 1) {
            if (flag) {
                for (int i = 0; sb.length() > 1 && i < sb.length(); i++) {
                    sb.deleteCharAt(i);
                }
                flag = false;
            } else {
                for (int i = sb.length() - 1; sb.length() > 1 && i >= 0; i -= 2) {
                    sb.deleteCharAt(i);
                }
                flag = true;
            }

        }

        return Integer.valueOf(String.valueOf(sb));
    }

}
