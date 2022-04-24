package com.leetcode.todo;

/**
 * @author :wyq
 * @date ：Created in 2022/4/24
 * @description : TODO
 * 868. 二进制间距
 */
public class Solution0868 {
    public static void main(String[] args) {
        Solution0868 obj = new Solution0868();
        System.out.println(obj.binaryGap(22));
    }

    public int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }
}