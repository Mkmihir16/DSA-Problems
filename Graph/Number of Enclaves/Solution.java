class Solution {
    public static void dfs(int[][] grid,int[][] vis,int i,int j){
        int[] row={-1,0,1,0};
        int[] col={0,-1,0,1};
        int s1=grid.length;
        int s2=grid[0].length;
        vis[i][j]=1;

        for(int m=0;m<4;m++){
            int newr=i+row[m];
            int newc=j+col[m];
            if(newr>=0 && newr<s1 && newc>=0 && newc<s2 && vis[newr][newc]==0 && grid[newr][newc]==1){
                dfs(grid,vis,newr,newc);
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        int count=0;
        for(int i=0;i<n;i++){
           if(grid[0][i]==1 && vis[0][i]==0){
            dfs(grid,vis,0,i);
           }
            if(grid[m-1][i]==1 && vis[m-1][i]==0){
            dfs(grid,vis,m-1,i);
           }
        }

        for(int i=0;i<m;i++){
           if(grid[i][0]==1 && vis[i][0]==0){
            dfs(grid,vis,i,0);
           }
            if(grid[i][n-1]==1 && vis[i][n-1]==0){
            dfs(grid,vis,i,n-1);
           }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}