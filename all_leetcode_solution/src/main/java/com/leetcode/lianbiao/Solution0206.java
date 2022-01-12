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
        ListNode ans = head;

        return ans;
    }
}