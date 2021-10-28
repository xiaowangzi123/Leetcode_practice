package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/28
 * @description : 较大分组的位置
 */
public class Solution0830 {
    public static void main(String[] args) {
        Solution0830 obj = new Solution0830();
        String s = "abbxxxxzzy";
        System.out.println(obj.largeGroupPositions(s));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length(), i = 0, start = 0;
        char temp = s.charAt(0);
        while (i < n) {
            List<Integer> list = new ArrayList<>();
            if (temp != s.charAt(i)) {
                temp = s.charAt(i);
                if (i - start > 2) {
                    list.add(start);
                    list.add(i - 1);
                    ans.add(list);
                }
                start = i;
            }
            i++;
        }

        return ans;
    }
}