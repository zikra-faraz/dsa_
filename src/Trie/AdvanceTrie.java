package Trie;
class AdvanceTrieNode {
    AdvanceTrieNode[] child;
    int cntEnd;
    int cntPrefix;
    AdvanceTrieNode(){
        child  = new AdvanceTrieNode[26];
        cntEnd = 0;
        cntPrefix = 0;
    }
    boolean containChar(char ch){
        return  child[ch-'a'] != null;
    }
      AdvanceTrieNode get(char ch){
        return  child[ch-'a'];
    }
    void  put (char ch , AdvanceTrieNode node){
        child[ch-'a'] = node;
    }
    void increaseEnd (){
        cntEnd++;
    }
    void increasePrefix(){
        cntPrefix++;
    }
    void deleteEnd(){
        cntEnd--;
    }
    public void reducePrefix() {
        /* Decrement the counter */
        cntPrefix--;
    }
    public int getEnd() {
        return cntEnd;
    }

    public int getPrefix() {
        return cntPrefix;
    }
}
public class AdvanceTrie {
    AdvanceTrieNode root;
    AdvanceTrie(){
        root = new AdvanceTrieNode();
    }
    void insert(String word){
        AdvanceTrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(!curr.containChar(ch)){
                curr.put(ch ,new AdvanceTrieNode());
            }
            curr = curr.get(ch);
            curr.increasePrefix();
        }
        curr.increaseEnd();
    }
    int countWordEqualTo(String word){
        AdvanceTrieNode curr =  root;
        for(char ch : word.toCharArray()){
            if(curr.containChar(ch)){
                curr = curr.get(ch);
            }else {
                return 0;
            }
        }
        return curr.getEnd();
    }
    int countWordStartWith(String word){
        AdvanceTrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.containChar(ch)){
                curr = curr.get(ch);
            }else {
                return 0;
            }
        }
        return curr.getPrefix();
    }
    void erase(String word){
        AdvanceTrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.containChar(ch)){
                curr = curr.get(ch);
                curr.reducePrefix();
            }else return;
        }
        curr.deleteEnd();
    }
}
