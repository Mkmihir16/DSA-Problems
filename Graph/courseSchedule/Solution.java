class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean vis[]=new boolean[numCourses];
        int indeg[]=new int[numCourses];

        for(int i=0;i<graph.size();i++){
           for(int j:graph.get(i)){
            indeg[j]++;
           }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);

            for(int n:graph.get(node)){
                indeg[n]--;
                if(indeg[n]==0){
                    q.add(n);
                }
            }
        }

    if(res.size()==numCourses)
    {
        return true;
    }
        return false;
    }
    
}