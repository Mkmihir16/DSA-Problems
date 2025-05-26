public class Solution {

    public static int findTargetSumWays(int[] val, int sum) {
        int n=val.length;
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1; // There's one way to achieve sum 0 (by choosing no elements)
        }
        for(int i=0;i<sum + 1; i++) {
            dp[0][i] = 0; // There's no way to achieve a positive sum with no elements
        }
        for(int i=1; i<=n;i++){
            for(int j=1;j<=sum;j++){
                int v = val[i - 1];
                if(j >= v) {
                    // Including condition
                    int include = dp[i][j - v];
                    // Excluding condition
                    int exclude = dp[i - 1][j];
                    dp[i][j] = include + exclude;
                } else {
                    // Cannot include this item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum]; // The number of ways to achieve the target sum
    }
    public static void main(String[] args) {
        int[] val={1,2,3};
        int sum=4;

        System.out.println("Number of ways to achieve target sum: " + findTargetSumWays(val, sum));
    }
}
