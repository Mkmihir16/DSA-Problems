import java.util.*;
public class Solution {
    public static  int findMaxCost(int i,int[] val,int[] wt,int W){
        if(i==val.length || W==0){
            return 0;
        }

        if(wt[i]<=W){
            int ans1=val[i]+findMaxCost(i+1, val, wt, W-wt[i]);
            int ans2=findMaxCost(i+1, val, wt, W);
            return Math.max(ans1,ans2) ;
        }
        else{
            return findMaxCost(i+1, val, wt, W);
        }
    }
    public static int findCost_using_memoization(int i,int[] val,int[] wt,int W,int[][] dp){
        if(i==val.length || W==0){
            return 0;
        }
        if(dp[i][W]!=-1){
            return dp[i][W];
        }
        if(wt[i]<=W){
            int ans1=val[i]+findCost_using_memoization(i+1, val, wt, W-wt[i],dp);
            int ans2=findCost_using_memoization(i+1, val, wt, W,dp);
            dp[i][W]=Math.max(ans1,ans2) ;
            return dp[i][W];
        }
        else{
            dp[i][W]=findCost_using_memoization(i+1, val, wt, W,dp);
            return dp[i][W];
        }
    }
    public static  int findCost_using_tabulation(int[] val,int[] wt,int W){

        int n=val.length;
        int dp[][]=new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=W;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(j>=w){
                    //including condition
                    int profit1=v+dp[i-1][j-w];
                    //excluding condition
                    int profit2=dp[i-1][j];
                    dp[i][j]=Math.max(profit1,profit2);
                }
                else{
                    int profit=dp[i-1][j];
                    dp[i][j]=profit;
                }
            }
        }
        System.out.println("DP Table:");
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }
        public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(findMaxCost(0,val,wt,W)); //using rcursion

        int[][] dp=new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        //using memoization
        System.out.println( findCost_using_memoization(0,val,wt,W,dp)); //using memoization
        //using tabulation
        System.out.println(findCost_using_tabulation(val,wt,W)); //using tabulation
    }
}
