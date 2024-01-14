package com.leetcode.s0001_0100;

import com.leetcode.bean.ListNode;

/**
 * @author :wyq
 * @date ：Created in 2021/9/30
 * @description : 删除排序链表中的重复元素
 */
public class Solution0083 {
    public static void main(String[] args) {
        Solution0083 obj = new Solution0083();
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(1);
        System.out.println(obj.deleteDuplicates(list));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }
}