
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
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abfce";
        System.out.println("Longest Common Substring Length: " + longestCommonSubstring(str1, str2));
    }
}
