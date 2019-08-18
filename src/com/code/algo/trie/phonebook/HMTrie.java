/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.algo.trie.phonebook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HMTrie {

    private HMTrieNode root;

    public HMTrie() {
        root = new HMTrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, HMTrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            HMTrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new HMTrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            // set leaf node
            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        HMTrieNode t = searchNode(word);

        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public HMTrieNode searchNode(String str) {
        Map<Character, HMTrieNode> children = root.children;
        HMTrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        HMTrie t = new HMTrie();
        t.insert("dear");
        t.insert("deal");
        t.insert("do");
        t.insert("he");
        t.insert("hen");
        t.insert("heat");

        System.out.println("hen present in trie : " + t.search("hen"));
        System.out.println("hear present in trie : " + t.search("hear"));
        System.out.println("deal present in trie : " + t.search("deal"));
        System.out.println("========================");

    }
}

