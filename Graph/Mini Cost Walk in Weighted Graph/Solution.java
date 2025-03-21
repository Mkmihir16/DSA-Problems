class Solution {
    public int find(int[] par,int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par,par[x]);
    }
    public void Union(int[] par,int x,int y,int[] rank){
        int par1=find(par,x);
        int par2=find(par,y);

        if(par1==par2){
            return;
        }
        else{
            if(rank[par1]>rank[par2]){
                par[par2]=par1;;
            }
            else if(rank[par1]<rank[par2]){
                par[par1]=par2;
            }
            else{
                par[par2]=par1;
                rank[par1]++;
            }
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] par=new int[n];
        int[] rank=new int[n];
        int[] res=new int[query.length];
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }
        for(int[] arr:edges){
            Union(par,arr[0],arr[1],rank);
        }
         for(int[] arr:edges){
           int first=arr[0];
           int sec=arr[1];
           int rootPar=find(par,first);
           cost[rootPar]=cost[rootPar] & arr[2];
        }
       for(int i=0;i<query.length;i++){
        int par0=find(par,query[i][0]);
         int par1=find(par,query[i][1]);
        if(par0!=par1){
            res[i]=-1;
        }
        else{
        res[i]=cost[par0];
        }
       }
       return res;
    }
}