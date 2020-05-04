package com.code.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchUtil {
	TreeNode root;

	public BinarySearchUtil(TreeNode root) {
		this.root=root;
	}
	
	 public void displayLeftView() {
	    	System.out.println(leftViewOfTree(root).toString());
	    }
	    
	    public List<Integer> leftViewOfTree(TreeNode root) {
	    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    	queue.add(root);
	    	List<Integer> nodes = new ArrayList<>();
	    	int size=1;
	    	while(!queue.isEmpty()) {
	    		size = queue.size();
	    		nodes.add(queue.peek().getData());
	    		for(int i=0;i<size;i++) {
	    			TreeNode head = queue.poll();
	    			if(head.left!=null)
	    				queue.add(head.left);
	    			if(head.right!=null)
	    				queue.add(head.right);
	    		}
	    	}
	    	return nodes;
	    }
	    
	    public int highestWidthCount(TreeNode root) {
	    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    	queue.add(root);
	    	int maxLevel = 0;
	    	int size=1;
	    	while(!queue.isEmpty()) {
	    		size = queue.size();
	    		
	    		for(int i=0;i<size;i++) {
	    			TreeNode head = queue.poll();
	    			if(head.left!=null)
	    				queue.add(head.left);
	    			if(head.right!=null)
	    				queue.add(head.right);
	    		}
	    		size = queue.size();
	    		maxLevel = size>maxLevel?size:maxLevel;
	    	}
	    	
	    	return maxLevel;
	    }
	    
}
