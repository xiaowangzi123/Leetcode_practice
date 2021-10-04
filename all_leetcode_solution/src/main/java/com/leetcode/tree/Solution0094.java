package com.leetcode.tree;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/2
 * @description :二叉树的中序遍历
 */
public class Solution0094 {
    public static void main(String[] args) {
        Solution0094 obj = new Solution0094();
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(obj.inorderTraversal(t1));
        System.out.println(obj.inorderTraversal2(t1));
        System.out.println(obj.inorderTraversal3(t1));


    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        middleRecursive(root, res);
        return res;
    }

    /**
     * 递归
     */
    public void middleRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        middleRecursive(root.left, res);
        res.add(root.val);
        middleRecursive(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;

    }

    /**
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 x）：
     * <p>
     * 1.如果x无左孩子，先将x的值加入答案数组，再访问x的右孩子，即x=x.right。
     * 2.如果x有左孩子，则找到x左子树上最右的节点（即左子树中序遍历的最后一个节点，x在中序遍历中的前驱节点）记为predecessor。
     * 根据 predecessor 的右孩子是否为空，进行如下操作。
     * 2.1如果predecessor的右孩子为空，则将其右孩子指向x，然后访问x的左孩子，即x=x.left。
     * 2.2如果predecessor的右孩子不为空，则此时其右孩子指向x，说明我们已经遍历完x的左子树,
     * 将predecessor的右孩子置空，将x的值加入答案数组，然后访问x的右孩子，即 x=x.right。
     * 3.重复上述操作，直至访问完整棵树。
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null) {
            // 如果没有左孩子，则直接访问右孩子
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                // predecessor 节点就是当前root节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
        }
        return res;
    }


}