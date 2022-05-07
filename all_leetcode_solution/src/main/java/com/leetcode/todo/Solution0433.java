package com.leetcode.todo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2022/5/7
 * @description :
 */
public class Solution0433 {
    public static void main(String[] args) {
        Solution0433 obj = new Solution0433();
        System.out.println(obj.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

    private String start;
    private String end;
    private String[] bank;

    private int minStep = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        this.start = start;
        this.end = end;
        this.bank = bank;

        helper(new HashSet<>(), start, 0);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    public void helper(Set<String> set, String curr, int step) {
        if (curr.equals(end)) {
            minStep = Math.min(minStep, step);
            return;
        }

        for (String compareStr : bank) {
            int diffrent = 0;
            for (int i = 0; i < end.length(); i++) {
                if (compareStr.charAt(i) != curr.charAt(i)) {
                    if (++diffrent > 1) {
                        break;
                    }
                }
            }

            if (diffrent == 1 && !set.contains(compareStr)) {
                set.add(compareStr);
                helper(set, compareStr, step + 1);
                set.remove(compareStr);
            }
        }

    }

}