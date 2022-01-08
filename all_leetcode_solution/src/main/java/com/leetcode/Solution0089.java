package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2022/1/8
 * @description: 格雷编码
 */
public class Solution0089 {
    public static void main(String[] args) {
        Solution0089 obj = new Solution0089();
        System.out.println(obj.grayCode(2));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }

}