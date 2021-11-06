package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description : 重新格式化电话号码
 */
public class Solution1694 {
    public static void main(String[] args) {
        Solution1694 obj = new Solution1694();
        System.out.println(obj.reformatNumber("1-23-45 6"));
        System.out.println(obj.reformatNumber("123 4-567"));
        System.out.println(obj.reformatNumber("123 4-5678"));
    }

    public String reformatNumber(String number) {
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for (char c : number.toCharArray()) {
            if ('0' <= c && c <= '9') {
                ans.append(c);
                count++;
                if (count % 3 == 0) {
                    ans.append('-');
                    count = 0;
                }
            }
        }

        if (count == 0) {
            ans.deleteCharAt(ans.length() - 1);
        } else if (count == 1) {
            ans.deleteCharAt(ans.length() - 2);
            ans.insert(ans.length() - 2, '-');

        }

        return ans.toString();
    }
}
