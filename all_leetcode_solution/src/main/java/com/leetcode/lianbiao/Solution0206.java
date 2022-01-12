package com.leetcode.lianbiao;

import com.leetcode.bean.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/18
 * @description：
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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = head;
        ListNode p2 = ans.next;

        while (p2 != null) {
            ListNode tmp = p2.next;
            p2.next = ans;
            ans = p2;
            p2 = tmp;
        }
        head.next = null;
        return ans;
    }

    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;
    }
}