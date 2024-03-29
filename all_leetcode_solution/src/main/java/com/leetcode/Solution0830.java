package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/28
 * @description : 较大分组的位置
 */
public class Solution0830 {
    public static void main(String[] args) {
        Solution0830 obj = new Solution0830();
        String s = "aaa";
        System.out.println(obj.largeGroupPositions3(s));
        String s1 = "abbxxxxzzy";
        System.out.println(obj.largeGroupPositions3(s1));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length(), i = 0, start = -1;
        while (i < n) {
            List<Integer> list = new ArrayList<>();
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (i - start > 2) {
                    list.add(start + 1);
                    list.add(i);
                    ans.add(list);
                }
                start = i;
            }
            i++;
        }
        return ans;
    }

    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length(), i = 0, count = 1;
        while (i < n) {
            List<Integer> list = new ArrayList<>();
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (count > 2) {
                    list.add(i - count + 1);
                    list.add(i);
                    ans.add(list);
                }
                count = 1;
            } else {
                count++;
            }
            i++;
        }
        return ans;
    }

    public List<List<Integer>> largeGroupPositions3(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length(), count = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (count > 2) {
                    ans.add(Arrays.asList(i - count + 1, i));
                }
                count = 1;
            } else {
                count++;
            }
        }
        return ans;
    }
}