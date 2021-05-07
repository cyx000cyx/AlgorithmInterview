package com.algorithm.interview.tree;

import com.algorithm.interview.common.TreeNode;

/**
 * 897. 递增顺序搜索树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class No897IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);

        return root;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        root.left = null;

        inorder(root.right);
    }

    public static void main(String[] args) {
        No897IncreasingBST day = new No897IncreasingBST();
        TreeNode treeNode = day.increasingBST(null);
        System.out.println(treeNode);
    }
}
