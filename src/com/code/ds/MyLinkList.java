package com.code.ds;

public class MyLinkList {

	private LLNode head;

	public MyLinkList() {		
	}
	
	public void addAfter(int data) {
		LLNode newNode = new LLNode(data);
		if(isListEmpty()) {
			head=newNode;
		}
		else {
			LLNode temp=head;
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
		LLNode inode = head;
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
	
	public static void main(String[] args) {
		MyLinkList llist = new MyLinkList();
		llist.addAfter(4);
		llist.addAfter(5);
		llist.addAfter(6);
		llist.addAfter(7);
		
		llist.display();
	}
	
}
