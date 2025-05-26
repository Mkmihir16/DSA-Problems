
public class Solution {
    public static int findMaxCost_Tabulation(int[] val,int[] wt,int W,int n){
        int[][] dp = new int[n + 1][W + 1];

        // Initialize the first row and column
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // If weight is 0, max value is 0
        }
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0; // If no items, max value is 0
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (j >= w) {
                    // Including condition
                    int profit1 = v + dp[i][j - w];
                    // Excluding condition
                    int profit2 = dp[i - 1][j];
                    dp[i][j] = Math.max(profit1, profit2);
                } else {
                    // Cannot include this item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][W]; // The maximum value for the full capacity W
    }
    public static void main(String[] args) {
        int[] val={15,14,10,45,30};
        int[] wt={2,5,1,3,4};
        int W=7;
        int n=val.length;

        //using tabulation
        System.out.println(findMaxCost_Tabulation(val, wt, W, n));
    }
}
