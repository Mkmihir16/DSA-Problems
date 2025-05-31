public class Solution {
    public static boolean fun(String str1,String str2){
        int n=str1.length();
        int m=str2.length();

        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=m;i++){
            if(str2.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str2.charAt(j-1)=='*'){
                    dp[i][j]= dp[i-1][j] || dp[i][j-1];
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1) || str2.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1="abcd";
        String str2="ab?";

        System.out.println(fun(str1,str2));;
    }
}
