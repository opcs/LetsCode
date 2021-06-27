/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.LRUCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Typically LRU cache is implemented using a doubly linked list and a hash map.
 * Doubly Linked List is used to store list of pages with most recently used page at the start of the list. So, as more pages are
 * added to the list, least recently used pages are moved to the end of the list with page at tail being the least recently used
 * page in the list.
 * Hash Map (key: page number, value: page) is used for O(1) access to pages in cache
 * When a page is accessed, there can be 2 cases:
 * 1. Page is present in the cache - If the page is already present in the cache, we move the page to the start of the list.
 * 2. Page is not present in the cache - If the page is not present in the cache, we add the page to the list.
 * How to add a page to the list:
 * a. If the cache is not full, add the new page to the start of the list.
 * b. If the cache is full, remove the last node of the linked list and move the new page to the start of the list.
 */
public class LRUCache {

    private DoublyLinkedList pageList;
    private Map<Integer, Node> pageMap;
    private int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.pageList = new DoublyLinkedList(cacheSize);
        this.pageMap = new ConcurrentHashMap<Integer, Node>();
    }

    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }

    public void accessPage(int pageNumber) {
        Node pageNode = null;
        if (pageMap.containsKey(pageNumber)) {
            // If page is present in the cache, move the page to the start of list
            pageNode = pageMap.get(pageNumber);
            pageList.movePageToHead(pageNode);
        } else {
            // If the page is not present in the cache, add the page to the cache
            if (pageList.getCurrentSize() == pageList.getSize()) {
                // If cache is full, we will remove the tail from the cache pageList
                pageList.removePageFromTail(pageMap.get(pageList.getTail().getPageNumber()));
                // Remove it from map too
                pageMap.remove(pageList.getTail().getPageNumber());
            }
            pageNode = pageList.addPageToList(pageNumber);
            pageMap.put(pageNumber, pageNode);
        }
    }

    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();

        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
    }
}
