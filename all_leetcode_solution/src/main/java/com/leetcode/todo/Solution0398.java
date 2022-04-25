package com.leetcode.todo;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2022/4/25
 * @description : TODO
 *
 * 398. 随机数索引
 */
public class Solution0398 {
    public static void main(String[] args) {

    }

    Map<Integer, List<Integer>> pos;
    Random random;

    public Solution0398(int[] nums) {
        pos = new HashMap<Integer, List<Integer>>();
        random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            pos.putIfAbsent(nums[i], new ArrayList<Integer>());
            pos.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = pos.get(target);
        return indices.get(random.nextInt(indices.size()));
    }
}