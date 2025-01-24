class Solution {
    public static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void createGraph(int[][] flights, ArrayList<Edge>[] graph,int n){
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            Edge e=new Edge(flights[i][0],flights[i][1],flights[i][2]);
            graph[flights[i][0]].add(e);
        }
    }

    public class Info{
        int vertex;
        int cost;
        int k;

        Info(int vertex,int cost,int k){
            this.vertex=vertex;
            this.cost=cost;
            this.k=k;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph=new ArrayList[n];
        //creating a graph
        createGraph(flights,graph,n);

        // performing dijkstra
        int[] dis=new int[n];
        for(int i=0;i<dis.length;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src,0,0));


        while(!q.isEmpty()){
            Info curr=q.remove();

            if(curr.k>k){
                continue;
            }
            for(int i=0;i<graph[curr.vertex].size();i++){
                Edge e=graph[curr.vertex].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(curr.cost+wt<dis[v] && curr.k<=k){
                    dis[v]=curr.cost  +wt;
                    q.add(new Info(v,dis[v],curr.k+1));
                }
               
            }

        }
        if(dis[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dis[dst];
    }
}