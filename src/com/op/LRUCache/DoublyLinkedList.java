/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.LRUCache;

public class DoublyLinkedList {

    private int currentSize;
    private final int size;

    private Node head;
    private Node tail;

    public DoublyLinkedList(int size) {
        this.size = size;
        currentSize = 0;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
        }
    }

    public Node addPageToList(int pageNumber) {
        Node pageNode = new Node(pageNumber);
        if (head == null) {
            head = pageNode;
            tail = pageNode;
            currentSize = 1;
            return pageNode;
        } else if (currentSize < size) {
            currentSize++;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
        return pageNode;
    }

    public void movePageToHead(Node pageNode) {
        if (pageNode == null || pageNode == head) {
            return;
        }

        removePageFromTail(pageNode);

        Node prev = pageNode.getPrev();
        Node next = pageNode.getNext();
        prev.setNext(next);

        if (next != null) {
            next.setPrev(prev);
        }

        pageNode.setPrev(null);
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
    }

    /**
     * @param pageNode
     */
    public void removePageFromTail(Node pageNode) {
        if (pageNode == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        }
    }
}
