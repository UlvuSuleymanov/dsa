package org.example.tree;

import org.w3c.dom.Node;

public class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}
