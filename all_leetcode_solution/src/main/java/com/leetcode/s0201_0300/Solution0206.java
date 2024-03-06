package com.leetcode.s0201_0300;

import com.leetcode.bean.ListNode;

/**
 *  反转链表
 */
public class Solution0206 {
    public static void main(String[] args) {
        Solution0206 obj = new Solution0206();
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        System.out.println(obj.reverseList(l1));
    }


    public ListNode reverseList(ListNode head) {
        ListNode ans = null;
        //当前指针节点
        ListNode curr = head;
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            //临时节点，暂存当前节点的下一节点，用于后移
            ListNode nextTemp = curr.next;
            //当前节点指向原链表中之前的节点
            curr.next = ans;
            //此时当前节点不在指向临时节点
            ans = curr;
            //当前指针后移
            curr = nextTemp;
        }
        return ans;
    }
}