package com.op.algo.Linklist;


public class LinkList {

	private ListNode head;

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public LinkList() {		
	}
	
	public void addAfter(int data) {
		ListNode newNode = new ListNode(data);
		if(isListEmpty()) {
			head=newNode;
		}
		else {
			ListNode temp=head;
			while(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			temp.setNext(newNode);
		}
	}

	private boolean isListEmpty() {
		return head==null?true:false;
	}
	
	public void display() {
		ListNode inode = head;
		StringBuilder sb = new StringBuilder();
		if(inode==null) {
			sb.append("no data in list");
		}else {
			sb.append(" " + inode.getData());
			while(inode.getNext()!=null) {
				sb.append(", " + inode.getNext().getData());
				inode=inode.getNext();
			}
		}
		System.out.println(sb.toString());
	}
	
	public ListNode reverse(ListNode head) {
		ListNode prev=null;
		ListNode current=head;
		if(head==null||head.getNext()==null) return head;
		
		/*1. save the next node
		  2. make current node points to prev
		  3. update prev ref
		  4. update current ref */
		
		while(current!=null) {
			ListNode next = current.getNext();
			current.setNext(prev);
			prev=current;
			current=next;
		}
		return prev;
	}
	
	
	public static void main(String[] args) {
		LinkList llist = new LinkList();
		llist.addAfter(4);
		llist.addAfter(5);
		llist.addAfter(6);
		llist.addAfter(7);
		
		llist.display();
		
		llist.setHead(llist.reverse(llist.getHead())); 
		llist.display();
		
	}
	
}
