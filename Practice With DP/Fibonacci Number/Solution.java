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
    public static void main(String[] args){
        int n=15;
        int[] dp =new int[n+1];
        System.out.println(fibonacci(n));
        System.out.println(fibonacci_with_memoization(n,dp));
    }
}