
package com.code.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    public static TreeNode root;
    public BinarySearchTree(){
        root = null;
    }
    
    public boolean find(int id){
       TreeNode current = root;
       while(current!=null){

          if(current.data==id){
             return true;
          }else if(current.data>id){
             current = current.left;
          }else{
             current = current.right;
          }
       }
       return false;
    }
    public boolean delete(int id){
       TreeNode parent = root;
       TreeNode current = root;
       boolean isLeftChild = false;
       while(current.data!=id){
          parent = current;
          if(current.data>id){
             isLeftChild = true;
             current = current.left;
          }else{
             isLeftChild = false;
             current = current.right;
          }
          if(current ==null){
             return false;
          }
       }
       //if i am here that means we have found the TreeNode
       //Case 1: if TreeNode to be deleted has no children
       if(current.left==null && current.right==null){
          if(current==root){
             root = null;
          }
          if(isLeftChild ==true){
             parent.left = null;
          }else{
             parent.right = null;
          }
       }
       //Case 2 : if TreeNode to be deleted has only one child
       else if(current.right==null){
          if(current==root){
             root = current.left;
          }else if(isLeftChild){
             parent.left = current.left;
          }else{
             parent.right = current.left;
          }
       }
       else if(current.left==null){
          if(current==root){
             root = current.right;
          }else if(isLeftChild){
             parent.left = current.right;
          }else{
             parent.right = current.right;
          }
       }else if(current.left!=null && current.right!=null){
          
            // now we have to find the minimum element in the right sub tree i.e successor
          TreeNode successor  = getSuccessor(current);
          if(current==root){
             root = successor;
          }else if(isLeftChild){
             parent.left = successor;
          }else{
             parent.right = successor;
          }        
          successor.left = current.left;
       }     
       return true;      
    }
    
    public TreeNode getSuccessor(TreeNode deleleTreeNode){
        return minValue(deleleTreeNode.right);

    }

    public TreeNode getPredecessor(TreeNode deleleTreeNode) {
        return maxValue(deleleTreeNode.left);

    }

    /**
     * loop down to find the rightmost leaf
     * @param left
     */
    private TreeNode maxValue(TreeNode left) {
        TreeNode current = left;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    /**
     * loop down to find the leftmost leaf
     * @param right
     * @return
     */
    private TreeNode minValue(TreeNode right) {
        TreeNode current = right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void insert(int id) {
       TreeNode newTreeNode = new TreeNode(id);
       if(root==null){
          root = newTreeNode;
          return;
       }
       TreeNode current = root;
       TreeNode parent = null;
       while(true){
          parent = current;
          if(id<current.data){          
             current = current.left;
             if(current==null){
                parent.left = newTreeNode;
                return;
             }
          }else{
             current = current.right;
             if(current==null){
                parent.right = newTreeNode;
                return;
             }
          }
       }
    }

    public void insertMe(int id) {
        TreeNode newTreeNode = new TreeNode(id);
        if (root == null) {
            root = newTreeNode;
            return;
        }
        TreeNode current = root;
        TreeNode parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newTreeNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newTreeNode;
                    return;
                }
            }
        }
    }
    public void display(TreeNode root){
       if(root!=null){
          display(root.left);
          System.out.print(" " + root.data);
          display(root.right);
       }
    }
    
   
    
   
    public static void main(String arg[]){
       BinarySearchTree b = new BinarySearchTree();
       b.insert(3);b.insert(8);
       b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
       b.insert(20);b.insert(25);b.insert(15);b.insert(16);
       BinarySearchUtil util = new BinarySearchUtil(root);
       util.displayLeftView();    // [3, 1, 2, 6, 15, 16]
       
       int width = util.highestWidthCount(b.root);    // 3 expected
       System.out.println("max width of tree: " + width);
       System.out.println("Original Tree : ");
       b.display(root);      
       System.out.println("");
       System.out.println("Check whether TreeNode with value 4 exists : " + b.find(4));
       System.out.println("Delete TreeNode with no children (2) : " + b.delete(2));      
       b.display(root);
       System.out.println("\n Delete TreeNode with one child (4) : " + b.delete(4));     
       b.display(root);
       System.out.println("\n Delete TreeNode with Two children (10) : " + b.delete(10));      
       b.display(root);
    }
 }

