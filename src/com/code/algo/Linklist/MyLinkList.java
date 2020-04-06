package com.code.algo.Linklist;

public class MyLinkList<E> {
	
	MyNode<E> head;
	
	public void reverse() {
		
	}
	
	public void add(E item) {
		MyNode<E> node = new MyNode(item);
		MyNode<E> bnode=head;
		
		if(head!=null) {
			 node.next = head;
			 head=node;
			
		}else {
			head=node;
		}
	}
	
	public void remove(E item) {
		MyNode<E> current=head;
		System.out.println("current: " + current.item);
		if(current==null) return ;
		
		MyNode<E> nextNode = current.next;
		while(current!=null) {
			if(current.item==item) {
				System.out.println("item matched: " + nextNode.item);
				current=nextNode;
			}
				current=nextNode;
		}
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

        public E getItem() {
			return item;
		}

		public void setItem(E item) {
			this.item = item;
		}

		public MyNode<E> getNext() {
			return next;
		}

		public void setNext(MyNode<E> next) {
			this.next = next;
		}

		MyNode(E element) {
            this.item = element;
            this.next = null;
        }

		public MyNode() {
			// TODO Auto-generated constructor stub
		}
    }

}
