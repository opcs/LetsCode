package com.op.algo.Linklist;

public class MyLinkList<E> {

	Node<E> head;

	public Node<E> getHead() {
		return head;
	}
	
	public void iterativeReverse() {
		Node prev=null, current=head;
		
		while(current!=null) {
			Node<E> next = current.next;   // bkp
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
		System.out.println(toString());
	}

	public void reverse() {
		head = reverse(this.head);
		System.out.println(toString());
	}

	private Node<E> reverse(Node<E> head) {

		if (head == null || head.next == null)
			return head;
		Node<E> remaining = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return remaining;
	}

	public void addFirst(E item) {
		Node<E> newNode = new Node(item);
		Node<E> bnode = head;

		if (head != null) {
			newNode.next = head;
			head = newNode;

		} else {
			head = newNode;
		}
	}

	public void addAtEnd(E item) {
		Node<E> newNode = new Node(item);
		Node<E> fnode = head;

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
		Node<E> temp = head;
		Node<E> prev = null;
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
		Node<E> node = new Node();
		node = head;
		while (node != null) {
			sb.append(node.getItem());
			sb.append(" ");
			node = node.next;
		}
		return sb.toString();
	}

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node() {
		}

		Node(E element) {
			this.item = element;
			this.next = null;
		}

		public E getItem() {
			return item;
		}

	}

}
