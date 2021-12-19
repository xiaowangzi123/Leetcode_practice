package com.leetcode.tree;

import com.leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wyq
 * @create time: 2021/12/16
 * @description: 对称二叉树
 */
public class Solution0112 {
    public static void main(String[] args) {
        Solution0112 obj = new Solution0112();
        TreeNode t9 = new TreeNode(1, null, null);
        TreeNode t8 = new TreeNode(2, null, null);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t6 = new TreeNode(4, null, t9);
        TreeNode t5 = new TreeNode(13, null, null);
        TreeNode t4 = new TreeNode(11, t7, t8);
        TreeNode t3 = new TreeNode(8, t5, t6);
        TreeNode t2 = new TreeNode(4, t4, null);
        TreeNode t1 = new TreeNode(5, t2, t3);

        System.out.println(obj.hasPathSum2(t1, 22));

    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeList = new LinkedList<>();
        Queue<Integer> valList = new LinkedList<>();
        nodeList.add(root);
        valList.add(root.val);

        while (!nodeList.isEmpty()) {
            TreeNode curNode = nodeList.poll();
            int temp = valList.poll();
            if (curNode.left == null && curNode.right == null) {
                if (temp == targetSum) {
                    return true;
                }
            }
            if (curNode.left != null) {
                nodeList.offer(curNode.left);
                valList.offer(curNode.val + temp);
            }
            if (curNode.right != null) {
                nodeList.offer(curNode.right);
                valList.offer(curNode.val + temp);
            }
        }
        return false;
    }
}