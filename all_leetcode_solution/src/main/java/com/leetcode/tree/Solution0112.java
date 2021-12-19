package com.leetcode.tree;

import com.leetcode.bean.TreeNode;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2021/12/16
 * @description: 对称二叉树
 */
public class Solution0112 {
    public static void main(String[] args) {
        Solution0112 obj = new Solution0112();
        /*TreeNode t9 = new TreeNode(1, null, null);
        TreeNode t8 = new TreeNode(2, null, null);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t6 = new TreeNode(4, null, t9);
        TreeNode t5 = new TreeNode(13, null, null);
        TreeNode t4 = new TreeNode(11, t7, t8);
        TreeNode t3 = new TreeNode(8, t5, t6);
        TreeNode t2 = new TreeNode(4, t4, null);
        TreeNode t1 = new TreeNode(5, t2, t3);*/

        TreeNode t13 = new TreeNode(13, null, null);
        TreeNode t12 = new TreeNode(12, null, null);
        TreeNode t11 = new TreeNode(11, null, null);
        TreeNode t10 = new TreeNode(10, null, null);
        TreeNode t9 = new TreeNode(9, null, null);
        TreeNode t8 = new TreeNode(8, null, null);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t6 = new TreeNode(6, t12, t13);
        TreeNode t5 = new TreeNode(5, t10, t11);
        TreeNode t4 = new TreeNode(4, t8, t9);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(obj.hasPathSum2(t1, 19));


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

        /**
         * 取出一个父节点，添加左右两个子节点
         * 判断当前节点是否是叶子节点，是的话判断与目标值是否相同
         */
        while (!nodeList.isEmpty()) {
            TreeNode curNode = nodeList.poll();
            int temp = valList.poll();
            if (curNode.left == null && curNode.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (curNode.left != null) {
                nodeList.offer(curNode.left);
                valList.offer(curNode.left.val + temp);
            }
            if (curNode.right != null) {
                nodeList.offer(curNode.right);
                valList.offer(curNode.right.val + temp);
            }
        }
        return false;
    }



}