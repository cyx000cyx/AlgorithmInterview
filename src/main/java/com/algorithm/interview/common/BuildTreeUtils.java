package com.algorithm.interview.common;

import com.alibaba.fastjson.JSON;

public class BuildTreeUtils {

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

    public static void InorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
    }

    public static void InorderTraversalByMorris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        TreeNode pre;
        while (current != null) {

        }
    }

    public static void PostorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
    }

    public static void PreorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
    }

    public static void main(String[] args) {
        TreeNode result = BuildTreeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println(JSON.toJSONString(result));
    }
}
