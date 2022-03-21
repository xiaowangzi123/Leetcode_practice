package com.leetcode.todo;

import com.leetcode.bean.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wyq
 * @create time: 2022/3/21
 * @description: TODO
 * 两数之和 IV - 输入 BST
 */
public class Solution0653 {
    public static void main(String[] args) {
        Solution0653 obj = new Solution0653();

    }

    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}