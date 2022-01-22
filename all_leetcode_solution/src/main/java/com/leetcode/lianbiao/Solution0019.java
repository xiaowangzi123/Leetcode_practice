package com.leetcode.lianbiao;

import com.leetcode.bean.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2022/1/22
 * @description: 删除链表的倒数第 N 个结点
 */
public class Solution0019 {
    public static void main(String[] args) {
        Solution0019 obj = new Solution0019();
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        System.out.println(obj.removeNthFromEnd(l1, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        System.out.println(len);
        ListNode cur = head;
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }

        return cur;
    }
}