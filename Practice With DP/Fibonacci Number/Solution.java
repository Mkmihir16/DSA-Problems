import java.util.*;

public class Solution{
    //fibonacci with recursion
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static int fibonacci_with_memoization(int n,int[] dp){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=fibonacci_with_memoization(n-1,dp)+fibonacci_with_memoization(n-2,dp);
        return dp[n];
    }
    public static int fibonacci_with_tabulation(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args){
        int n=15;
        int[] dp =new int[n+1];
        System.out.println("Fibonacci with recursion "+fibonacci(n));
        System.out.println("Fibonacci with memoization "+fibonacci_with_memoization(n,dp));
        System.out.println("Fibonacci with tabulation "+fibonacci_with_tabulation(n));
    }
}