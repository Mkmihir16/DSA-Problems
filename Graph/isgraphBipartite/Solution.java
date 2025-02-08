class Solution {
    public boolean isBipartite(int[][] graph) {
        int col[]=new int[graph.length];
        Arrays.fill(col,-1);

        for(int i=0;i<graph.length;i++){
           if(col[i]==-1){
            col[i]=0;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int n=q.poll();
                for(int j=0;j<graph[n].length;j++){
                    int index=graph[n][j];
                    if(col[index]==-1){
                        col[index]=1-col[n];
                        q.add(index);
                    }
                    else if(col[index]==col[n]){
                        return false;
                    }
                }
            }
           }  
        }
        return true;
    }
}