package com.algorithm.interview.tree;

import com.algorithm.interview.common.TreeNode;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class No297SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");

        Integer[] dataIArr = new Integer[dataArr.length];
        for (int i = 0; i < dataArr.length; i++) {
            dataIArr[i] = Integer.parseInt(dataArr[i]);
        }

        return buildTree(dataIArr, 0);
    }

    public static TreeNode buildTree(Integer[] arr, int pointer) {
        if (pointer >= arr.length || arr[pointer] == null) {
            return null;
        }

        TreeNode tn = new TreeNode();
        tn.val = arr[pointer];
        tn.left = buildTree(arr, pointer * 2 + 1);
        tn.right = buildTree(arr, pointer * 2 + 2);
        return tn;
    }

    public static void main(String[] args) {

    }
}
