package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/19
 * @description : 找出所有子集的异或总和再求和
 */
public class Solution1863 {
    public static void main(String[] args) {
        Solution1863 obj = new Solution1863();
        int[] nums = {1, 3};
        System.out.println(obj.subsetXORSum(nums));
        System.out.println(obj.subsetXORSum2(nums));
    }

    /**
     * 回溯
     */
    int xor = 0;
    int res = 0;
    public int subsetXORSum(int[] nums) {
        dfs(nums, 0);
        return res;
    }
    public void dfs(int[] nums, int count){
        if(count == nums.length){
            res += xor;
            return;
        }

        dfs(nums, count+1);
        xor ^= nums[count];
        dfs(nums, count+1);
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
}