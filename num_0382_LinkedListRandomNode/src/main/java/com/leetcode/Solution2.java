package com.leetcode;

import java.util.Random;

/**
 * @author: wyq
 * @create time: 2022/1/16
 * @description: 链表随机节点
 */
public class Solution2 {
    ListNode list;
    Random random;

    public Solution2(ListNode head) {
        this.list = head;
        random = new Random();
    }

    public int getRandom() {
        int count = 0, ans = 0;
        while (list != null) {
            int rand = random.nextInt(++count);
            if (count == rand) {
                ans = list.val;
            }
            list = list.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(5, null);
        ListNode l2 = new ListNode(3, l3);
        ListNode l1 = new ListNode(1, l2);
        Solution2 obj = new Solution2(l1);
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }
}
