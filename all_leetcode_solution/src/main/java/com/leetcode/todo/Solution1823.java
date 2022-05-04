package com.leetcode.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2022/5/4
 * @description :TODO
 * 1823. 找出游戏的获胜者
 */
public class Solution1823 {
    public static void main(String[] args) {
        Solution1823 obj = new Solution1823();
        System.out.println(obj.findTheWinner(5, 2));
    }

    public int findTheWinner(int n, int k) {
        List<Integer> queue = new ArrayList<>();
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.remove(0));
            }
            queue.remove(0);
        }
        return queue.get(0);
    }

}