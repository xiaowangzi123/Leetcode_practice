package com.leetcode0589;

import java.util.List;

/**
 * Hello world!
 */
public class Solution {
    public static void main(String[] args) {
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node ch : root.children) {
            helper(ch, res);
        }
    }
}
