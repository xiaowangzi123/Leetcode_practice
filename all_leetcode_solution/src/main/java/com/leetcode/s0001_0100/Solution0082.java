package com.leetcode.s0001_0100;

import com.leetcode.bean.ListNode;

/**
 * @author :wyq
 * @date ：Created in 2021/9/30
 * @description : 删除排序链表中的重复元素Ⅱ
 */
public class Solution0082 {
    public static void main(String[] args) {
        Solution0082 obj = new Solution0082();
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(1);
        System.out.println(obj.deleteDuplicates(list));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
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