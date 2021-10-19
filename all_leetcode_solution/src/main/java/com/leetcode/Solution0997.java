package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description : 找到小镇的法官
 */
public class Solution0997 {
    public static void main(String[] args) {
        Solution0997 obj = new Solution0997();
//        int n = 3;
//        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};

        int n = 4;
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};

        System.out.println(obj.findJudge(n, trust));
        System.out.println(obj.findJudge2(n, trust));
        System.out.println(obj.findJudge3(n, trust));

    }

    /**
     * 1.如果存在法官，那么所有人都会信任法官，在结合条件1，可以得出信任法官的人数为n-1。
     * 2.如果不存在法官，那么也可能存在某些人被所有人信任，这个人的信任人数也为n-1，但是他也会信任别人。
     * 3.可以以此作为区分other和juage的条件，假设每个人都有信任值，那么定义一个数组长度为n，用来存放n个人的信任值:
     * 1)如果一个人信任了别人，那么将这个人的信任值-1
     * 2）如果一个人被别人信任，那么这个人的信任值＋1
     * 当一个人被所有人信任，并且他没有信任其它人时，这个人的信任值就是n- 1，那么此人就是法官。
     * 当一个人被所有人信任，但是他也信任了其他人时，这个人的信任值<n - 1。
     * 其它情况下，每个人的信任值都会小于n -1。
     */
    public int findJudge(int n, int[][] trust) {
        // 定义数组用于存放每个人的信任值
        int[] trustValues = new int[n + 1];

        // 遍历trust数组计算每个人的信任值
        for (int[] t : trust) {
            trustValues[t[0]]--;
            trustValues[t[1]]++;
        }

        // 遍历这n个人的信任值，如果存在 n - 1，则返回这个人的编号
        for (int i = 1; i <= n; i++) {
            if (trustValues[i] == (n - 1)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 小镇的法官谁都不信任，信任人数为0；
     * 小镇上的所有人都信任法官，信任法官的人数为n-1
     * p[i][0]:表示第i个人信任多少人
     * p[i][1]:表示第i个人有多少人信任自己
     */
    public int findJudge2(int n, int[][] trust) {
        int[][] people = new int[n + 1][2];
        for (int[] person : trust) {
            int out = person[0];
            int in = person[1];
            people[out][0]++;
            people[in][1]++;
        }
        for (int i = 1; i <= n; i++) {
            if (people[i][0] == 0 && people[i][1] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * flag[i]:表示第i个人是否有信任的人
     * count[i]:表示第i人被多少人信任
     * flag[i]=false && count[i]=n-1，表明第i人是法官
     */
    public int findJudge3(int n, int[][] trust) {
        boolean[] flag = new boolean[n + 1];
        int[] count = new int[n + 1];

        for (int[] t : trust) {
            flag[t[0]] = true;
            count[t[1]] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!flag[i] && count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}