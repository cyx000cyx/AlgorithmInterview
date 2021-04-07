package com.algorithm.interview.week4;

import com.algorithm.interview.common.NAryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class Day25PreorderTraversal {

    public List<Integer> preorder(NAryTreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(NAryTreeNode r, List<Integer> result) {
        if (r == null) {
            return;
        }
        result.add(r.val);
        for (NAryTreeNode child : r.children) {
            preorderTraversal(child, result);
        }
    }

    public static void main(String[] args) {

    }
}
