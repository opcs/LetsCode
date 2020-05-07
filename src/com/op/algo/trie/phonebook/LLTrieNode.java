
package com.op.algo.trie.phonebook;

import java.util.LinkedList;

/**
 * improved version than array, as using linked list
 */
class LLTrieNode
{

    char data;
    boolean isEnd;
    int count;
    LinkedList<LLTrieNode> childList;

    public LLTrieNode(char c) {
        childList = new LinkedList<LLTrieNode>();
        isEnd = false;
        data = c;
        count = 0;
    }

    public LLTrieNode getChild(char c) {
        if (childList != null)
            for (LLTrieNode eachChild : childList)
                if (eachChild.data == c)
                    return eachChild;
        return null;
    }
}