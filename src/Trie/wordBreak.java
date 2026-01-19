package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class wordBreak {
   static   Boolean[] memo;
  public static boolean recursive(String s, List<String> dict){
      HashSet<String> st = new HashSet<>(dict);
      return solve(s, 0 , st);
  }
  public static boolean solve(String s, int index , HashSet<String> set){
      if(s.length()  == index) return true;
      for (int i = index+1; i <= s.length() ; i++) {
          String part = s.substring(index , i );
          if(set.contains(part) && solve(s , i , set)){
              return true;
          }
      }

      return false;
  }

  public static  boolean memoize(String s, List<String> dict){
      memo = new Boolean[s.length()];
      HashSet<String> st = new HashSet<>(dict);
      return solveMemo(s, 0 , st);
  }
    public static boolean solveMemo(String s, int index , HashSet<String> set){
        if(s.length()  == index) return true;
        if (memo[index] != null) return memo[index];
        for (int i = index+1; i <= s.length() ; i++) {
            String part = s.substring(index , i );
            if(set.contains(part) && solve(s , i , set)){
                memo[index]  = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }

    public static boolean opitmize(String s, List<String> wordDict){
        HashSet<String> set =new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n ; i++){
            for(int j = 0 ; j<i ; j++){
                if(dp[j] && set.contains(s.substring(j , i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
      List<String> dict = new ArrayList<>();
      dict.add("i");
      dict.add("like");
      dict.add("sam");
      dict.add("samsung");
      dict.add("mobile");
        System.out.println( recursive("ilikesamsung" , dict));;
    }
}
