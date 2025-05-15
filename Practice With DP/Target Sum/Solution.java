
public class Solution {
    public static boolean findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int v=nums[i - 1];

                if(j>=v){
                    //including condition
                    boolean include = dp[i - 1][j - v];
                    //excluding condition
                    boolean exclude = dp[i - 1][j];
                    dp[i][j] = include || exclude;
                } else {
                    boolean exclude = dp[i - 1][j];
                    dp[i][j] = exclude;
                }
            }

        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;
        System.out.println("Target Sum: " + findTargetSumWays(nums, target));
    }
}
