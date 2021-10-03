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
        TreeNode t7 = new TreeNode(7,null,null);
        TreeNode t6 = new TreeNode(6,null,null);
        TreeNode t5 = new TreeNode(5,null,null);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3,t6,t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(obj.inorderTraversal(t1));
        System.out.println(obj.inorderTraversal2(t1));


    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        middleRecursive(root, res);
        return res;
    }

    /**
     * 递归
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