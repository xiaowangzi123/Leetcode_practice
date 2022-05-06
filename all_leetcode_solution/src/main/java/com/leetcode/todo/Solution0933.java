package com.leetcode.todo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :wyq
 * @date ：Created in 2022/5/6
 * @description : TODO
 * 933. 最近的请求次数
 */
public class Solution0933 {
}

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (t - queue.peek() > 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
