package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0029 {
    public static void main(String[] args) {
        Solution0029 obj = new Solution0029();
        int dividend = 10, divisor = 3;
        System.out.println(obj.divide(10, 3));

    }

    /**
     * 如果存在法官，那么所有人都会信任法官，在结合条件1，可以得出信任法官的人数为n-1。
     * 2.如果不存在法官，那么也可能存在某些人被所有人信任，这个人的信任人数也为n-1，但是他也会信任别人。
     * 3.可以以此作为区分other和juage的条件，假设每个人都有信任值，那么定义一个数组长度为n，用来存放n个人的信任值:
     * 1)如果一个人信任了别人，那么将这个人的信任值-1
     * 2）如果一个人被别人信任，那么这个人的信任值＋1
     *
     * 当一个人被所有人信任，并且他没有信任其它人时，这个人的信任值就是n- 1，那么此人就是法官。
     * 当一个人被所有人信任，但是他也信任了其他人时，这个人的信任值<n - 1。
     * 其它情况下，每个人的信任值都会小于n -1。
     *
     */
    public int divide(int dividend, int divisor) {
        return 0;
    }
}