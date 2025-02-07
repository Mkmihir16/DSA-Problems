class Solution {
    public static void dfs(char[][] board,int i,int j,int[][] vis){
        int s1=board.length;
        int s2=board[0].length;

        int row[]={-1,0,1,0};
        int col[]={0,-1,0,1};
        vis[i][j]=1;
        for(int m=0;m<4;m++){
            int newi=i+row[m];
            int newj=j+col[m];
            if(newi>=0 && newj>=0 && newi<s1 && newj<s2 && vis[newi][newj]==0 && board[newi][newj]=='O'){
            dfs(board,newi,newj,vis);
            }
        }
    }

    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int vis[][]=new int[m][n];
 
        // first row
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && vis[0][i]==0){
                dfs(board,0,i,vis);
            }
            if(board[m-1][i]=='O' && vis[m-1][i]==0){
                dfs(board,m-1,i,vis);
            }
        }

        //first column
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(board,i,0,vis);
            }
            if(board[i][n-1]=='O' && vis[i][n-1]==0){
                dfs(board,i,n-1,vis);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
}