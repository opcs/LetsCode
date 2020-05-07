/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.algo.trie.phonebook;

import java.util.LinkedList;

import java.util.*;

class HMTrieNode {

    char c;
    HashMap<Character, HMTrieNode> children = new HashMap<Character, HMTrieNode>();
    boolean isLeaf;

    public HMTrieNode() {
    }

    public HMTrieNode(char c) {
        this.c = c;
    }
}


