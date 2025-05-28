
public class Solution {
    public static boolean  findTarget_using_recursion(int i,int[] nums,int target){
        if(target==0){
            return true;
        }
        if(i==nums.length){
            return false;
        }
        if(nums[i]<=target){
            boolean res1=findTarget_using_recursion(i+1, nums, target-nums[i]);
            boolean res2=findTarget_using_recursion(i+1,nums,target);
            return res1  || res2;
        }
        else{
            return findTarget_using_recursion(i+1, nums, target);
        }
    }
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
        boolean dp[][]=new boolean[nums.length+1][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=false;
            }
        }
        System.out.println("Target Sum using memoization "+ findTarget_using_memoization(0,dp,nums,target));
        System.out.println("Target Sum using tabulation: " + findTargetSumWays(nums, target));
        System.out.println("Target Sum using recursioon: " + findTarget_using_recursion(0,nums, target));

    }
}
