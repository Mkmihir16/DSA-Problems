import java.util.*;
public class Solution {
    public static int climbingStairs(int n){
        if(n==0 || n==1){
            return 1;
        }
        return climbingStairs(n-1)+climbingStairs(n-2);
    }
    public static int climbingStairs_with_memoization(int n,int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=climbingStairs_with_memoization(n-1,dp)+climbingStairs_with_memoization(n-2,dp);
        return dp[n];
    }
    public static int climbingStairs_with_tabulation(int n){
        if(n==0 || n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n=4;
        int[] dp =new int[n+1];
        System.out.println(climbingStairs(n));
        System.out.println(climbingStairs_with_memoization(n,dp));
        System.out.println(climbingStairs_with_tabulation(n));
    }
}
