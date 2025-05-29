import java.util.*;    
class Solution {
    public int fun(int[] nums,int[] arr){
        int n=nums.length;
        int m=arr.length;
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums[i-1]==arr[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    int ans1=dp[i][j-1];
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }

        int arr[]=new int[hs.size()];
        int i=0;
        for(int num:hs){
           arr[i++]=num; 
        }

        Arrays.sort(arr);
        return fun(nums,arr);
    }
}