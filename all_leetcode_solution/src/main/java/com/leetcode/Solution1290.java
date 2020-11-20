package com.leetcode;

import com.leetcode.bean.ListNode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/20
 * @description：
 */
public class Solution1290 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        while (node.next != null) {
            System.out.print(node.val + ",");
            node.next = node.next.next;
        }
        System.out.println();

    }

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }
}