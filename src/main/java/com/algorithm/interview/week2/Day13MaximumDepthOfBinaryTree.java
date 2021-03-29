package com.algorithm.interview.week2;

import com.algorithm.interview.common.BuildTreeUtils;
import com.algorithm.interview.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Day13MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        traversal(root);

        return max;
    }

    int depth = 0;
    int max = depth;

    public void traversal(TreeNode tn) {
        depth++;
        max = Math.max(max, depth);
        if (tn == null || (tn.left == null && tn.right == null)) {
            depth--;
            return;
        }
        traversal(tn.left);
        traversal(tn.right);
        depth--;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode buildTree = BuildTreeUtils.buildTree(new Integer[]{3,9,20,null,null,15,7}, 0);
        Day13MaximumDepthOfBinaryTree day = new Day13MaximumDepthOfBinaryTree();
        System.out.println(day.maxDepth2(buildTree));
    }
}
