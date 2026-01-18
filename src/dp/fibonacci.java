package dp;

public class fibonacci {
    public static int recur(int n){
        if(n <= 1) return n;
        return recur(n-1)+recur(n-2);
    }
    public static int memoiz(int n , int[] dp){
      if(n<=1) return n;
      if(dp[n] != -1) return dp[n];
      dp[n] =  memoiz(n-1 , dp) + memoiz( n-2 , dp);
      return dp[n];
    }
    public static int tabul(int n ){
       if(n<=1) return n;
       int[] dp = new int[n+1];
       dp[0] = 0;
       dp[1] =1;

        for (int i = 2; i <= n ; i++) {
            dp[i]  = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
 public static int space(int n ){
        if(n<=1) return n;
        int prev2 = 0;
        int prev = 1;
        int curr = 0;
        for(int i = 2 ; i<= n ; i++){
            curr = prev + prev2;
            prev2  = prev;
            prev = curr;
        }


        return prev;
 }
}
