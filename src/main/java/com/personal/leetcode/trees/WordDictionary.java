package com.personal.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}

class WordDictionary {
    TrieNode trie;

    public WordDictionary() {
        this.trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode currNode = this.trie;

        for(int i = 0; i<word.length(); i++) {
            if(!currNode.children.containsKey(word.charAt(i))) {
                currNode.children.put(word.charAt(i), new TrieNode());
            }
            currNode = currNode.children.get(word.charAt(i));
        }
        currNode.isEndOfWord = true;
    }
    
    public boolean searchInNode(String word, TrieNode trie) {
        TrieNode currNode = trie;
        for(int i = 0; i<word.length(); i++) {
            if(!currNode.children.containsKey(word.charAt(i))) { //if not found
                if(word.charAt(i) == '.'){
                    for(char ch : currNode.children.keySet()){
                        TrieNode node = currNode.children.get(ch);
                        if(searchInNode(word.substring(i+1), node)) {
                            return true;
                        }
                    }
                }
                return false;
            }else{ // if character if found
                currNode = currNode.children.get(word.charAt(i));
            }
            
        }
        return currNode.isEndOfWord;
    }

    public boolean search(String word) {
        return searchInNode(word, this.trie);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */