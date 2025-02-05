class Solution {
    public static class Pair{
        int row;
        int col;
        int dis;
        Pair(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }

    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q=new LinkedList<>();
        int vis[][]=new int[mat.length][mat[0].length];
        int dis[][]=new int[mat.length][mat[0].length];
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int rowarr[]={-1,0,1,0};
        int colarr[]={0,-1,0,1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int dist=p.dis;
            dis[row][col]=dist;
            for(int i=0;i<4;i++){
                int newr=row+rowarr[i];
                int newc=col+colarr[i];
                if(newr>=0 && newc>=0 && newr<m && newc<n && vis[newr][newc]==0){
                    vis[newr][newc]=1;
                    q.add(new Pair(newr,newc,dist+1));
                }
            }
        }
        return dis;
    }
}