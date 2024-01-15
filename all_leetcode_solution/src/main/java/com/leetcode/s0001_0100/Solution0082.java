package com.leetcode.s0001_0100;

import com.leetcode.bean.ListNode;

/**
 * 删除排序链表中的重复元素Ⅱ
 */
public class Solution0082 {
    public static void main(String[] args) {
        Solution0082 obj = new Solution0082();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next.next = new ListNode(5);
        System.out.println(obj.deleteDuplicates(list));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        //创建一个临时节点temp，其值为0，它的下一个节点指向链表的头节点
        ListNode temp = new ListNode(0, head);
        ListNode cur = temp;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int value = cur.next.val;
                while (cur.next != null && cur.next.val == value) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return temp.next;
    }
}