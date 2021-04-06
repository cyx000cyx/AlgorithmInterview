package com.algorithm.interview.common;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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

    public static void InorderTraversal(TreeNode root, Function<? super Object, ? extends Object> f) {
        if (root == null) {
            return;
        }
        InorderTraversal(root.left, f);
        f.apply(root.val);
        InorderTraversal(root.right, f);
    }

    public static void InorderTraversalByMorris(TreeNode root, Function<? super Object, ? extends Object> f) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        TreeNode pre;
        while (current != null) {

        }
    }

    /**
     * 后序遍历
     * @param root
     * @param f
     */
    public static void PostorderTraversal(TreeNode root, Function<? super Object, ? extends Object> f) {
        if (root == null) {
            return;
        }
        PostorderTraversal(root.left, f);
        PostorderTraversal(root.right, f);
        f.apply(root.val);
    }

    /**
     * 先序遍历
     * @param root
     * @param f
     */
    public static void PreorderTraversal(TreeNode root, Function<? super Object, ? extends Object> f) {
        if (root == null) {
            return;
        }
        f.apply(root.val);
        PreorderTraversal(root.left, f);
        PreorderTraversal(root.right, f);
    }

    public static void main(String[] args) {
        TreeNode result = BuildTreeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println(JSON.toJSONString(result));
//        result = BuildTreeUtils.buildTree(new Integer[]{
//                1,
//                2,                              3,
//                4, null,                        null, 5,
//                null, 6, null, null,            null, null, null, null,
//                null, null, 7, 8, null, null, null, null,   null, null, null, null, null, null, null, null}, 0);
        BuildTreeUtils.InorderTraversal(result, a -> {
            System.out.println(a);
            return a;
        });
        System.out.println();
        BuildTreeUtils.PreorderTraversal(result, a -> {
            System.out.println(a);
            return a;
        });
        System.out.println();
        BuildTreeUtils.PostorderTraversal(result, a -> {
            System.out.println(a);
            return a;
        });
    }
}
