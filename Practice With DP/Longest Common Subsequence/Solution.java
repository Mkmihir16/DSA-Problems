
public class Solution {
    public static int lcs_using_recursion(String s1,String s2,int n,int m){
        if(n<0 ||m<0){
            return 0; // Base case: if either string is empty, LCS length is 0
        }

        if(s1.charAt(n)==s2.charAt(m)){
            return lcs_using_recursion(s1, s2, n-1, m-1)+1;
        }
        else{
            int ans1=lcs_using_recursion(s1, s2, n-1, m);
            int ans2=lcs_using_recursion(s1, s2, n, m-1);
            return Math.max(ans1, ans2); // Return the maximum of the two options
        }
    }
    public static int lcs_using_memoization(String s1, String s2, int n, int m, int[][] dp) {
        if (n < 0 || m< 0) {
            return 0; // Base case: if either string is empty, LCS length is 0
        }

        if (dp[n][m] != -1) {
            return dp[n][m]; // Return the cached result
        }

        if (s1.charAt(n) == s2.charAt(m)) {
            dp[n][m] = 1 + lcs_using_memoization(s1, s2, n - 1, m - 1, dp);
        } else {
            int ans1 = lcs_using_memoization(s1, s2, n - 1, m, dp);
            int ans2 = lcs_using_memoization(s1, s2, n, m - 1, dp);
            dp[n][m] = Math.max(ans1, ans2); // Store the maximum of the two options
        }
        return dp[n][m];
    }
    public static int lcs_using_tabulation(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=0; // If s2 is empty, LCS length is 0
        }
        for(int i=0;i<=m;i++){
            dp[0][i]=0; // If s1 is empty, LCS length is 0
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1]; // If characters match, add 1 to the LCS length
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]); // If characters don't match, take the max of excluding either character
                }
            }
        }
        return dp[n][m]; // The length of the longest common subsequence
    }
    public static void main(String[] args) {
        String s1="abcde";
        String s2="ace";
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1; // Initialize the memoization table with -1
            }
        }
        System.out.println("Length of Longest Common Subsequence is: " + lcs_using_recursion(s1, s2, n-1, m-1));
        System.out.println("Length of Longest Common Subsequence using DP is: " + lcs_using_memoization(s1, s2, n-1, m-1, dp));  
        System.out.println("Length of Longest Common Subsequence using Tabulation is: " + lcs_using_tabulation(s1, s2));
    }    
}
