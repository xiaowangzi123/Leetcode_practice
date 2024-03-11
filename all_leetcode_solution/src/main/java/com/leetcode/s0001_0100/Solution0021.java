package com.leetcode.s0001_0100;

import com.leetcode.bean.ListNode;

/**
 * 合并两个有序链表
 * TODO
 */
public class Solution0021 {
    public static void main(String[] args) {
        Solution0021 obj = new Solution0021();

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode end = null;
        ListNode first = l1;
        ListNode second = l2;

        while (first != null && second != null) {
            int temp1 = first.val;
            int temp2 = second.val;
            if (temp1 <= temp2) {
                if (head == null) {
                    head = first;
                    end = head;
                } else {
                    end.next = first;
                    end = end.next;
                }
                first = first.next;
            } else {
                if (head == null) {
                    head = second;
                    end = head;
                } else {
                    end.next = second;
                    end = end.next;
                }
                second = second.next;
            }
        }

        if (first != null) {
            end.next = first;
        }
        if (second != null) {
            end.next = second;
        }

        return head;
    }

}