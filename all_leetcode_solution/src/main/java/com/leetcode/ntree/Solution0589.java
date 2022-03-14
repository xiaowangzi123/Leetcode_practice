package com.leetcode.ntree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2022/3/10
 * @description : N叉树的前序遍历
 *  todo
 */
public class Solution0589 {
    public static void main(String[] args) {
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        List<Node> list = new ArrayList<>();
        list.add(n5);
        list.add(n6);
        Node n3 = new Node(3, list);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        List<Node> list1 = new ArrayList<>();
        list1.add(n3);
        list1.add(n2);
        list1.add(n4);
        Node n1 = new Node(1, list1);

        Solution0589 obj = new Solution0589();
        System.out.println(obj.preorder(n1));
        System.out.println("--------------");
        System.out.println(obj.preorder2(n1));

    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder2(Node root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorder2(node);
            }
        }
        return ans;
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
        if (root.children != null) {
            for (Node node : root.children) {
                helper(node, res);
            }
        }
    }
}
