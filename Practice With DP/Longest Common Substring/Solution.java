
public class Solution {
    public static int longestCommonSubstring(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int[][] dp=new int[n+1][m+1];
        int maxLenght=0;

        for(int i=0;i<=n;i++){
            dp[i][0]=0; // Base case: empty substring
        }
        for(int i=0;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1; // If characters match, extend the substring
                    maxLenght = Math.max(maxLenght, dp[i][j]); // Update maximum length found
                } else {
                    dp[i][j] = 0; // Reset to 0 if characters do not match
                }
            }
        }
        return maxLenght; // Return the length of the longest common substring
    }
    public static int longestCommonSubstring_memoization(String str1,String str2,int n,int m,int[][] dp,int[] res){
        if(n==0 ||m==0){
            return 0;
        }

        longestCommonSubstring_memoization(str1, str2, n - 1, m, dp, res);
    longestCommonSubstring_memoization(str1, str2, n, m - 1, dp, res);

        if(dp[n][m]!=-1){
            return dp[n][m];
        }


        if(str1.charAt(n-1)==str2.charAt(m-1)){
             dp[n][m] = 1 + ((n - 1 > 0 && m - 1 > 0) ? (dp[n - 1][m - 1] != -1 ? dp[n - 1][m - 1] : 0) : 0);
        res[0] = Math.max(res[0], dp[n][m]);
            return dp[n][m];
        }
        else{
            dp[n][m]=0;
            return dp[n][m];
        }
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abfce";
        int res[]={0};
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println("Longest Common Substring Length: " + longestCommonSubstring(str1, str2));
        System.out.println("Longest Common Substring Length using memoization "+ longestCommonSubstring_memoization(str1, str2,str1.length(),str2.length(),dp,res));
        System.out.println("real answer "+res[0]);
    }
}
