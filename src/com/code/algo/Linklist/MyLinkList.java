package com.code.algo.Linklist;

public class MyLinkList<E> {
	
	MyNode<E> head;
	
	public void reverse() {
		
	}
	
	public void addFirst(E item) {
		MyNode<E> newNode = new MyNode(item);
		MyNode<E> bnode=head;
		
		if(head!=null) {
			 newNode.next = head;
			 head=newNode;
			
		}else {
			head=newNode;
		}
	}
	
	public void addAtEnd(E item) {
		MyNode<E> newNode = new MyNode(item);
		MyNode<E> fnode=head;
		
		if(fnode!=null) {
			while(fnode.next!=null) {
				fnode=fnode.next;
			}
			 fnode.next = newNode;
			 newNode.next=null;
			
		}else {
			fnode=newNode;
			head=fnode;
		}
	}
	
	public void remove(E item) {
		
	}
	


	public String toString() {
		StringBuilder sb= new StringBuilder();
		MyNode<E> node = new MyNode();
		node=head;
		while(node!=null) {
			sb.append(node.getItem());
			sb.append(" ");
			node=node.next;
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
