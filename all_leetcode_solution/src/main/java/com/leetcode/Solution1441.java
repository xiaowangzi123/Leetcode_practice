package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 用栈操作构建数组
 */
public class Solution1441 {
    public static void main(String[] args) {
        Solution1441 obj = new Solution1441();
        System.out.println(obj.buildArray(new int[]{1, 3}, 3));
        System.out.println(obj.buildArray(new int[]{1, 2}, 4));
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (index == target.length) {
                break;

            }
            if (target[index] == i) {
                ans.add("Push");
                index++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}