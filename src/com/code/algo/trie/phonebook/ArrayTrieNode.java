/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.algo.trie.phonebook;

/**
 * Each trie node can only contains 'a'-'z' characters. So we can use a small array to store the character
 */
public class ArrayTrieNode {

    ArrayTrieNode[] arr;
    boolean isEnd;

    // Initialize your data structure here.
    public ArrayTrieNode() {
        this.arr = new ArrayTrieNode[26];
    }
}
