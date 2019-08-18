/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.LRUCache;


public class Node {

    private int pageNumber;
    private Node prev;
    private Node next;

    public Node(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return pageNumber + " ";
    }

}
