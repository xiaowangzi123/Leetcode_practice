package com.leetcode;

import com.leetcode.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :wyq
 * @date ：Created in 2022/5/16
 * @description : todo
 * 面试题 04.06. 后继者
 */
public class Interview0406 {


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }
}