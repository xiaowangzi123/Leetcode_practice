package com.leetcode0589;

import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2022/3/10
 * @description :
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}