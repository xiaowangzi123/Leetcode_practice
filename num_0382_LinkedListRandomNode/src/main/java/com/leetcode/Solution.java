package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: wyq
 * @create time: 2022/1/16
 * @description: 链表随机节点
 */
public class Solution {
    List<Integer> list;
    Random random;

    public Solution(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(5,null);
        ListNode l2 = new ListNode(3,l3);
        ListNode l1 = new ListNode(1,l2);
        Solution obj = new Solution(l1);
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }
}
