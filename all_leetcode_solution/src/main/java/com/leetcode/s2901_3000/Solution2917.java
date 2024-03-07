package com.leetcode.s2901_3000;

/**
 * 找出数组中的 K-or 值
 */
public class Solution2917 {
    public static void main(String[] args) {
        Solution2917 solution = new Solution2917();

        //9
        System.out.println(solution.findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4));
        //0
        System.out.println(solution.findKOr(new int[]{2,12,1,11,4,5}, 6));
        //15
        System.out.println(solution.findKOr(new int[]{10,8,5,9,11,6,8}, 1));

        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(15));

    }

    /**
     * 位运算
     * 由于数组元素值2^{31}，我们枚举0到30的每个比特位。
     * 遍历数组，如果第i个比特位上的1的个数 ≥k，则把 2^i加到答案中。
     *
     * 统计每一位上，所有数字在该位上 1的个数，如果超过了 k，则答案累加 2^k
     */
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt1 = 0;
            for (int x : nums) {
                cnt1 += x >> i & 1;
            }
            if (cnt1 >= k) {
                ans |= 1 << i;
            }
        }
        return ans;

    }
}
