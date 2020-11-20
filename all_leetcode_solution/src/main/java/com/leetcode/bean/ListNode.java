package com.leetcode.bean;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/20
 * @description：
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}