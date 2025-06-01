import java.util.Arrays;

public class Solution {
    public static int recursion(int n){
        if(n==0 || n==1){
            return 1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=recursion(i)*recursion(n-i-1);
        }
        return sum;
    }
    public static int memoization(int n,int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=memoization(i,dp)*memoization(n-i-1,dp);
        }
        dp[n]=sum;
        return sum;
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(recursion(n));
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(memoization(n,dp));
    }
}
