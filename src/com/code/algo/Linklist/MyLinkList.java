package com.code.algo.Linklist;

public class MyLinkList<E> {

	MyNode<E> head;

	public MyNode<E> getHead() {
		return head;
	}

	public void reverse() {
		head = reverse(this.head);
		System.out.println(toString());
		;
	}

	private MyNode<E> reverse(MyNode<E> head) {

		if (head == null || head.next == null)
			return head;
		MyNode<E> remaining = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return remaining;
	}

	public void addFirst(E item) {
		MyNode<E> newNode = new MyNode(item);
		MyNode<E> bnode = head;

		if (head != null) {
			newNode.next = head;
			head = newNode;

		} else {
			head = newNode;
		}
	}

	public void addAtEnd(E item) {
		MyNode<E> newNode = new MyNode(item);
		MyNode<E> fnode = head;

		if (fnode != null) {
			while (fnode.next != null) {
				fnode = fnode.next;
			}
			fnode.next = newNode;
			newNode.next = null;

		} else {
			fnode = newNode;
			head = fnode;
		}
	}

	public void remove(E item) {
		// 1. head node remove

		if (head.item == item) {
			head = head.next;
		}

		// 2. intermediate node remove
		MyNode<E> temp = head;
		MyNode<E> prev = null;
		while (temp.item != item) {
			prev = temp;
			temp = temp.next;
		}
		if (temp.next != null) {
			prev.next = temp.next;
		} else {
			// 3 end node to remove
			prev.next = null;
		}
		temp = null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		MyNode<E> node = new MyNode();
		node = head;
		while (node != null) {
			sb.append(node.getItem());
			sb.append(" ");
			node = node.next;
		}
		return sb.toString();
	}

	private static class MyNode<E> {
		E item;
		MyNode<E> next;

		public MyNode() {
		}

		MyNode(E element) {
			this.item = element;
			this.next = null;
		}

		public E getItem() {
			return item;
		}

	}

}
