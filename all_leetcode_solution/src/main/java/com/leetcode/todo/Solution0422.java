package com.leetcode.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2022/5/8
 * @description :TODO
 * 442. 数组中重复的数据
 */
public class Solution0422 {
    public static void main(String[] args) {
        Solution0422 obj = new Solution0422();
        System.out.println(obj.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    /**
     * 可以把每个元素值当做下标去处理
     * 其值取反，如果有同样的元素，其值就变成了正数
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            nums[index] *= -1;
            if (nums[index] > 0) {
                res.add(Math.abs(num));
            }
        }
        return res;
    }

}