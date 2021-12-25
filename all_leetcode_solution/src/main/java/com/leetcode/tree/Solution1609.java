package com.leetcode.tree;


import com.leetcode.bean.TreeNode;
import com.leetcode.tools.TreeNodeTools;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2021/12/25
 * @description: 奇偶树
 */
public class Solution1609 {
    public static void main(String[] args) {
        TreeNode t10 = new TreeNode(2, null, null);
        TreeNode t9 = new TreeNode(6, null, null);
        TreeNode t8 = new TreeNode(8, null, null);
        TreeNode t7 = new TreeNode(12, null, null);
        TreeNode t6 = new TreeNode(9, null, t10);
        TreeNode t5 = new TreeNode(7, t9, null);
        TreeNode t4 = new TreeNode(3, t7, t8);
        TreeNode t3 = new TreeNode(4, t5, t6);
        TreeNode t2 = new TreeNode(10, t4, null);
        TreeNode t1 = new TreeNode(1, t2, t3);

        Solution1609 obj = new Solution1609();
        System.out.println(obj.isEvenOddTree(t1));
    }

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                int val = temp.val;
                //偶数层，数据只能是奇数；奇数层，数据只是偶数
                if (level % 2 == val % 2) {
                    return false;
                }
                //偶数层，数据递减；奇数层，数据递增。
                if ((level % 2 == 0 && val <= prev) || (level % 2 == 1 && val >= prev)) {
                    return false;
                }
                prev = val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            level++;
        }
        return true;
    }

}

