package com.leetcode;

import com.leetcode.bean.ListNode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/20
 * @description：
 */
public class Solution1290 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        //此处代码去掉注释后，调用getDecimalValue方法得到的数据有误
        /*while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }*/

        System.out.println("-----------");
        Solution1290 obj = new Solution1290();
        System.out.println(obj.getDecimalValue(node));

    }

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }
}