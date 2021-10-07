package com.leetcode.tree;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/2
 * @description :二叉树的后序遍历
 */
public class Solution0145 {
    public static void main(String[] args) {
        Solution0145 obj = new Solution0145();
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(obj.postorderTraversal(t1));
        System.out.println(obj.postorderTraversal2(t1));
        System.out.println(obj.postorderTraversal3(t1));


    }

    //前序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postRecursive(root, res);
        return res;
    }

    /**
     * 递归
     */
    public void postRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postRecursive(root.left, res);
        postRecursive(root.right, res);
        res.add(root.val);
    }


    //迭代
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode preNode = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == preNode) {
                ans.add(root.val);
                preNode = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return ans;

    }

    //Morris遍历 todo
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                    addPath(res, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(res, root);
        return res;
    }

    public void addPath(List<Integer> res, TreeNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            res.add(node.val);
            node = node.right;
        }
        int left = res.size() - count, right = res.size() - 1;
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }

}