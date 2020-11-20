package com.leetcode.tools;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/20
 * @description：
 */
public class TreeNodeTools {
    /**
     * 前序遍历
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {//先将左结点入栈
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;//如果当前结点有右结点遍历它的右结点
            }
        }
        return list;
    }


    /**
     * 后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode q = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.peek();//取得结点但不让它出栈
                if ((root.right == null) || (root.right == q)) {//判断该节点的右结点是否访问过
                    stack.pop();
                    list.add(root.val);
                    q = root;
                    root = null;
                } else {
                    root = root.right;
                }
            }
        }
        return list;
    }


}