package com.leetcode.lianbiao;

import com.leetcode.bean.ListNode;

import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/11/2
 * @description : 删除链表中的节点
 */
public class Solution0237 {
    public static void main(String[] args) {
        Solution0237 obj = new Solution0237();

        ListNode l4 = new ListNode(9, null);
        ListNode l3 = new ListNode(1, l4);
        ListNode l2 = new ListNode(5, l3);
        ListNode l1 = new ListNode(4, l2);
        System.out.println(l1);
        
        obj.deleteNode(l2);
        System.out.println(l1);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}