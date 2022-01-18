package com.leetcode.backtrace;

/**
 * @author :wyq
 * @date ：Created in 2021/11/19
 * @description : 找出所有子集的异或总和再求和
 */
public class Solution1863 {
    public static void main(String[] args) {
        Solution1863 obj = new Solution1863();
        System.out.println(obj.subsetXORSum(new int[]{1, 5, 6}));
        System.out.println(obj.subsetXORSum2(new int[]{1, 3}));
        System.out.println(obj.subsetXORSum3(new int[]{1, 3}));
        System.out.println("-----------------");
        System.out.println(1^3^3);
    }

    /**
     * 回溯
     */
    int sum = 0;
    int temp = 0;

    public int subsetXORSum(int[] nums) {
        backtrace(nums, 0);
        return sum;
    }

    public void backtrace(int[] nums, int index) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp ^= nums[i];
            sum += temp;
            backtrace(nums, i + 1);
            temp ^= nums[i];
        }
    }


    /**
     * 数组的子集个数1 << n
     * 以{1,3}为例，四个子集分别为{}{1}{3}{1,3}
     * 00 01 10 11为0表示不取当前元素，为1表示取当前元素
     */
    public int subsetXORSum2(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            int tmp = 0;
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) > 0) {
                    tmp ^= nums[j];
                }
            }
            ans += tmp;
        }
        return ans;
    }

    public int subsetXORSum3(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            ans |= nums[i];
        }
        return ans << (n - 1);
    }
}