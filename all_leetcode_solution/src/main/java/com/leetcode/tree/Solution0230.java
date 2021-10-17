package com.leetcode.tree;

import com.leetcode.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :二叉搜索树中第K小的元素
 */
public class Solution0230 {
    public static void main(String[] args) {
        Solution0230 obj = new Solution0230();
        TreeNode t6 = new TreeNode(1, null, null);
        TreeNode t5 = new TreeNode(4, null, null);
        TreeNode t4 = new TreeNode(2, t6, null);
        TreeNode t3 = new TreeNode(6, null, null);
        TreeNode t2 = new TreeNode(3, t4, t5);
        TreeNode t1 = new TreeNode(5, t2, t3);

        System.out.println(obj.kthSmallest(t1,3));
        System.out.println(obj.kthSmallest(t1,5));
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}