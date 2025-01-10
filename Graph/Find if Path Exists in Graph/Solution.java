class Solution {
    class Edge{
        int src;
        int desti;
        Edge(int src,int desti){
            this.src=src;
            this.desti=desti;
        }
    }
    public boolean hasPath(boolean arr[],int src,int desti, ArrayList<Edge>[] graph){
        if(src==desti){
            return true;
        }
        arr[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!arr[e.desti] && hasPath(arr,e.desti,desti,graph)){
                return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph=new ArrayList[n];

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){
            int curr=edges[i][0];
            int reverse=edges[i][1];
            graph[curr].add(new Edge(edges[i][0],edges[i][1]));
            graph[reverse].add(new Edge(edges[i][1],edges[i][0]));
        }
        boolean[] arr=new boolean[n];
        return hasPath(arr,source,destination,graph);
    }
}