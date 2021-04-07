package com.algorithm.interview.week3;

import com.algorithm.interview.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Day15InorderTraversal {

    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversalRecursive(root);
        return result;
    }

    public void inorderTraversalRecursive(TreeNode r) {
        if (r == null) {
            return;
        }
        inorderTraversalRecursive(r.left);
        result.add(r.val);
        inorderTraversalRecursive(r.right);
    }

    public static void main(String[] args) {

    }
}
