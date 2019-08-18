package com.code.ds;

public class LLNode {
private int data;
private LLNode next;


public LLNode(int data) {
	this.data = data;
	this.next = null;
}
public LLNode() {
}
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public LLNode getNext() {
	return next;
}
public void setNext(LLNode next) {
	this.next = next;
}


}

