package Trie;

import java.util.List;
class  TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}
public class Trie {



           TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        //O(L)  l is length of the word
        public  void insert(String word){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                // unicode a = 97 ch = a 97-97 = 0
                int idx = ch-'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.isEnd = true;
        }
        public  boolean search(String word){
            TrieNode curr= root;
            for(char ch : word.toCharArray()){
                int idx = ch - 'a';
                if(curr.children[idx] == null) return false;
                curr = curr.children[idx];
            }
            return curr.isEnd;
        }
        public  boolean startsWith(String prefix){
            TrieNode curr = root;
            for(char ch : prefix.toCharArray()){
                int idx = ch-'a';
                if(curr.children[idx] == null) return false;
                curr = curr.children[idx];
            }
            return true;
        }



    }



