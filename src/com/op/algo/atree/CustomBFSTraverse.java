package com.op.algo.atree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomBFSTraverse {
	TreeNode root;

	public CustomBFSTraverse(TreeNode root) {
		this.root = root;
	}

	public void displayLeftView() {
		System.out.println(leftViewOfTree(root).toString());
	}

	public List<Integer> leftViewOfTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		List<Integer> nodes = new ArrayList<>();
		int size = 1;
		while (!queue.isEmpty()) {
			size = queue.size();    // each level size
			nodes.add(queue.peek().getData());
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				if (head.left != null)
					queue.add(head.left);
				if (head.right != null)
					queue.add(head.right);
			}
		}
		return nodes;
	}

	public int findHighestWidth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int maxWidth = 0;
		int size = 1;
		while (!queue.isEmpty()) {
			size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				if (head.left != null)
					queue.add(head.left);
				if (head.right != null)
					queue.add(head.right);
			}
			size = queue.size();
			maxWidth = size > maxWidth ? size : maxWidth;
		}

		return maxWidth;
	}

}
