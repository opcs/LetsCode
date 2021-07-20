package com.op.algo.atree;

public class TreeNode {

    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(TreeNode leftNode, TreeNode rchild, int data) {
        this.left = leftNode;
        this.right = rchild;
        this.data = data;
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

}
