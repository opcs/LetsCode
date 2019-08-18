package com.code.algo.trie.phonebook;

import java.util.Iterator;

public class LLTrie {

    private LLTrieNode root;

    /* Constructor */
    public LLTrie() {
        root = new LLTrieNode(' ');
    }

    /* This function is used to insert a word in trie */
    public void insert(String word) {
        if (search(word) == true)
            return;
        LLTrieNode current = root;
        for (char ch : word.toCharArray()) {
            LLTrieNode child = current.getChild(ch);
            if (child != null)
                current = child;
            else {
                // If child not present, adding it io the list
                current.childList.add(new LLTrieNode(ch));
                current = current.getChild(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }

    /* This function is used to search a word in trie */
    public boolean search(String word) {
        LLTrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.getChild(ch) == null)
                return false;
            else
                current = current.getChild(ch);
        }
        if (current.isEnd == true)
            return true;
        return false;
    }

    /* This function is used to remove function from trie */
    public void remove(String word) {
        if (search(word) == false) {
            System.out.println(word + " does not present in trien");
            return;
        }
        LLTrieNode current = root;
        for (char ch : word.toCharArray()) {
            LLTrieNode child = current.getChild(ch);
            if (child.count == 1) {
                current.childList.remove(child);
                return;
            }
            else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }

    public static void printAllWordsInTrie(LLTrieNode root, String s) {
        LLTrieNode current = root;
        if (root.childList == null || root.childList.size() == 0)
            return;
        Iterator<LLTrieNode> iter = current.childList.iterator();
        while (iter.hasNext()) {
            LLTrieNode node = iter.next();
            s += node.data;
            printAllWordsInTrie(node, s);
            if (node.isEnd == true) {
                System.out.print(" " + s);
                s = s.substring(0, s.length() - 1);
            }
            else {
                s = s.substring(0, s.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LLTrie t = new LLTrie();
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
        System.out.println("Printing all word present in trie : ");
        printAllWordsInTrie(t.root, "");
    }
}
