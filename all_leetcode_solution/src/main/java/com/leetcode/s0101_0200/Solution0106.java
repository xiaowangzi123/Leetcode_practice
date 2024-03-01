package com.leetcode.s0101_0200;

import com.leetcode.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 * TODO
 */
public class Solution0106 {
    public static void main(String[] args) {

    }

    private Map<Integer, Integer> pos = new HashMap<>();

    /**
     * 1、创建一个哈希表pos记录记录每个值在中序遍历中的位置。
     * 2、先利用后序遍历找根节点：后序遍历的最后一个数，就是根节点的值；
     * 3、确定左右子树的后序遍历和中序遍历，先递归创建出左右子树，然后创建根节点。
     * 4、最后将根节点的左右指针指向两棵子树。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            //记录中序遍历的根节点位置
            pos.put(inorder[i], i);
        }
        return dfs(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode dfs(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
        if (pl > pr) {
            return null;
        }
        int k = pos.get(postorder[pr]);
        TreeNode root = new TreeNode(postorder[pr]);
        root.left = dfs(inorder, postorder, il, k - 1, pl, pl + k - 1 - il);
        root.right = dfs(inorder, postorder, k + 1, ir, pl + k - 1 - il + 1, pr - 1);
        return root;
    }
}