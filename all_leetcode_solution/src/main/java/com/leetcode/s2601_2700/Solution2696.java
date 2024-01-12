package com.leetcode.s2601_2700;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wyq
 * @date 2024/1/12
 * @desc 删除子串后的字符串最小长度
 */
public class Solution2696 {
    public static void main(String[] args) {
        Solution2696 solution = new Solution2696();
        System.out.println(solution.minLength("ABFCACDB"));
        System.out.println(solution.minLength("ACBBD"));

    }

    public int minLength2(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('B' == c && !queue.isEmpty() && queue.peek() == 'A') {
                queue.poll();
            } else if ('D' == c && !queue.isEmpty() && queue.peek() == 'C') {
                queue.poll();
            } else {
                queue.addFirst(c);
            }
        }
        return queue.size();
    }

    public int minLength(String s) {
        List<Character> queue = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('B' == c && !queue.isEmpty() && queue.get(queue.size() - 1) == 'A') {
                queue.remove(queue.size() - 1);
            } else if ('D' == c && !queue.isEmpty() && queue.get(queue.size() - 1) == 'C') {
                queue.remove(queue.size() - 1);
            } else {
                queue.add(c);
            }
        }
        return queue.size();
    }
}
