package com.leetcode.tree;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/2
 * @description :二叉树的中序遍历
 */
public class Solution0094 {
    public static void main(String[] args) {
        Solution0094 obj = new Solution0094();
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t3, null);
        TreeNode t1 = new TreeNode(1, null, t2);

        System.out.println(obj.inorderTraversal(t1));
        System.out.println(obj.inorderTraversal2(t1));


    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        middleRecursive(root, res);
        return res;
    }

    /**
     * 回溯
     */
    public void middleRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        middleRecursive(root.left, res);
        res.add(root.val);
        middleRecursive(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;

    }
}