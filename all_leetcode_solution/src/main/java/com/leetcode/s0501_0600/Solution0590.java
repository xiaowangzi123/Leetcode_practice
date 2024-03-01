package com.leetcode.s0501_0600;

import com.leetcode.ntree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 *  N叉树的后序遍历
 * TODO
 */
public class Solution0590 {
    public static void main(String[] args) {

    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node ch : root.children) {
            helper(ch, res);
        }
        res.add(root.val);
    }
}