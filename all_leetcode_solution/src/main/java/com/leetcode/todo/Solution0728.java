package com.leetcode.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2022/3/31
 * @description: TODO
 * 自除数
 */
public class Solution0728 {
    public static void main(String[] args) {
        Solution0728 obj = new Solution0728();
        System.out.println(obj.selfDividingNumbers(1, 22));
        System.out.println(obj.selfDividingNumbers(47, 85));

    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivisor(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isSelfDivisor(int n) {
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || n % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}