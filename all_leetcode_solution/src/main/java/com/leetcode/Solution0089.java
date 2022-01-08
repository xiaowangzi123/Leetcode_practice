package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(obj.grayCode2(2));
        System.out.println(obj.grayCode(3));
        System.out.println(obj.grayCode2(3));
        System.out.println(1 << 2);
    }

    /**
     * 第n个格雷码 G(n) = n xor (n>>1)
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }

    public List<Integer> grayCode2(int n) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(0));
        }
        List<Integer> ans = new ArrayList<>();
        List<Integer> temp = grayCode2(n - 1);

        for (int i = 0; i < temp.size(); i++) {
            ans.add(temp.get(i));
        }
        for (int i = 0; i < temp.size(); i++) {
            ans.add(i + temp.size(), temp.get(temp.size() - i - 1) + temp.size());
        }
        return ans;
    }

}