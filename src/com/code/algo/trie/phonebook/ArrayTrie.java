package com.code.algo.trie.phonebook;

// an improved version of trie
public class ArrayTrie {

    private ArrayTrieNode root;

    public ArrayTrie() {
        root = new ArrayTrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        ArrayTrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
                ArrayTrieNode temp = new ArrayTrieNode();
                p.arr[index] = temp;
                p = temp;
            } else {
                p = p.arr[index];
            }
        }
        p.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        ArrayTrieNode p = searchNode(word);
        if (p == null) {
            return false;
        } else {
            if (p.isEnd)
                return true;
        }
        return false;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        ArrayTrieNode p = searchNode(prefix);
        if (p == null) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayTrieNode searchNode(String s) {
        ArrayTrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (p.arr[index] != null) {
                p = p.arr[index];
            } else {
                return null;
            }
        }
        if (p == root)
            return null;
        return p;
    }

    public static void main(String[] args) {
        ArrayTrie t = new ArrayTrie();
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
