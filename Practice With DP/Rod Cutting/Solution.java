public class Solution {
    public static int cutRod(int[] length,int[] price,int n,int l) {
        int[][] dp=new int[n+1][l+1];

        for(int i=0;i<=n;i++) {
            dp[i][0] = 0; // No length means no price
        }
        for(int i=0;i<=l;i++) {
            dp[0][i] = 0; // No rod means no price
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=l;j++){
                int v= length[i - 1];
                if(v<=j){
                    // Including condition
                    int include = price[i - 1] + dp[i][j - v];
                    // Excluding condition
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    // Cannot include this item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][l]; // The maximum obtainable value
       
    }
    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int l=8;
        int n=length.length;
        System.out.println("Maximum obtainable value is: " + cutRod(length, price, n,l));
    }
}
