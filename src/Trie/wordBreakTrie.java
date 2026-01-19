package Trie;
import java.util.*;
public class wordBreakTrie {
    // not good still using substring
//    public static boolean wordBreak(String word){
//        int n = word.length();
//        if(n== 0)return true;
//        for (int i = 1; i <=n ; i++) {
//            String firstPart = word.substring(0 , i);
//            String second = word.substring(i);
//            if(search(firstPart) && wordBreak(second)){
//                return true;
//            }
//        }
//        return false;
//    }
    Trie trie = new Trie();
    Boolean[] memo;
    public  boolean wordBreak(String s, List<String> wordDict){
     for (String words : wordDict){
        trie.insert(words);
     }
    memo = new Boolean[s.length()];
     return dfs(s, 0);
    }
    public boolean dfs(String s, int index){
        if(index == s.length()) return true;
        if(memo[index] != null) return true;
      TrieNode curr = trie.root;
        for (int i = index; i < s.length() ; i++) {
            int idx = s.charAt(i) - 'a';
            if(curr.children[idx] == null) break;
            curr = curr.children[idx];
            if(curr.isEnd && dfs(s, i+1)){
                memo[index]  = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"i", "like","sam","samsung","mobile"};
        String key = "ilikesamsung";
    }
}
