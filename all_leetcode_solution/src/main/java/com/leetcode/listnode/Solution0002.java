package com.leetcode.listnode;

import com.leetcode.bean.ListNode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/1/5
 * @description: 两数相加
 */
public class Solution0002 {
    public static void main(String[] args) {
        Solution0002 obj = new Solution0002();
        ListNode l13 = new ListNode(3, null);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(2,l12);

        ListNode l23 = new ListNode(4, null);
        ListNode l22 = new ListNode(6, l23);
        ListNode l21 = new ListNode(5,l22);
        System.out.println(obj.addTwoNumbers(l11,l21));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();

        int k = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            if (ans == null) {
                ans = new ListNode((a + b + k) % 10);
            }
            k = (a + b + k) / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (k > 0) {
                ans = new ListNode(k);
            }
        }
        return ans;
    }


}