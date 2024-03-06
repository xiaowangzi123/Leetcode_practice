package com.leetcode.s0401_0500;

import com.leetcode.bean.ListNode;

/**
 * 两数相加 II
 */
public class Solution0445 {
    public static void main(String[] args) {
        Solution0445 obj = new Solution0445();


        //加不加括号值不一样
        System.out.println((long) (1804289383 * 2));
        System.out.println((long) 1804289383 * 2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newl1 = reverse(l1);
        ListNode newl2 = reverse(l2);
        ListNode newHead = null, next = null;
        int mod = 0;
        while (newl1 != null || newl2 != null || mod != 0) {
            int val1 = newl1 != null ? newl1.val : 0;
            int val2 = newl2 != null ? newl2.val : 0;
            int sum = val1 + val2 + mod;
            ListNode node = new ListNode(sum % 10);
            if (newHead == null) {
                newHead = next = node;
            } else {
                next.next = node;
                next = next.next;
            }
            mod = sum / 10;
            if (newl1 != null) {
                newl1 = newl1.next;
            }
            if (newl2 != null) {
                newl2 = newl2.next;
            }
        }
        return reverse(newHead);

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode newHead = reverse(node);
        node.next = head;
        head.next = null;
        return newHead;

    }

}