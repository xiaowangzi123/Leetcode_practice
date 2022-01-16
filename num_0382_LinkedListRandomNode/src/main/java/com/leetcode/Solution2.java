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
        int count = 1, ans = 0;
        /*for (ListNode node=list;node!=null;node=node.next){
            if (random.nextInt(count)==0){
                ans=node.val;
            }
            count++;
        }*/
        ListNode node = list;
        while (node != null) {
            int rand = random.nextInt(count);
            if (0 == rand) {
                ans = node.val;
            }
            count++;
            node = node.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(5, null);
        ListNode l2 = new ListNode(3, l3);
        ListNode l1 = new ListNode(1, l2);
        Solution2 obj = new Solution2(l1);
        int a = 0, b = 0, c = 0,d=0;
        for (int i = 0; i < 1000; i++) {
            int temp = obj.getRandom();
            if (temp == 1) {
                a++;
            } else if (temp == 3) {
                b++;
            } else if (temp == 5) {
                c++;
            }else {
                d++;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }
}
