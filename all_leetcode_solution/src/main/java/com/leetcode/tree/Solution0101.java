package com.leetcode.tree;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2021/12/16
 * @description: 对称二叉树
 */
public class Solution0101 {
    public static void main(String[] args) {
        Solution0101 obj = new Solution0101();
        TreeNode t7 = new TreeNode(3, null, null);
        TreeNode t6 = new TreeNode(4, null, null);
        TreeNode t5 = new TreeNode(4, null, null);
        TreeNode t4 = new TreeNode(3, null, null);
        TreeNode t3 = new TreeNode(2, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(obj.isSymmetric(t1));

    }


    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root, root);
    }

    public boolean checkSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null){
            return false;
        }

        return t1.val==t2.val && checkSymmetric(t1.left,t2.right) && checkSymmetric(t1.right,t2.left);
    }


}