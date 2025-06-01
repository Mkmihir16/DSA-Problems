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
    public static int tabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int ans=0;
            for(int j=0;j<i;j++){
                ans+=dp[j]*dp[i-j-1];
            }
            dp[i]=ans;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=10;
        // System.out.println(recursion(n));
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("catalan number using memoization "+memoization(n,dp));
        System.out.println("catalan number using tabulation "+tabulation(n));
    }
}
