class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int indeg[]=new int[adj.size()];
        
        // for(ArrayList<Integer> i:adj.size())
        
        for(int i=0;i<adj.size();i++){
            for(int n:adj.get(i)){
                indeg[n]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ar=new ArrayList<>();
        while(!q.isEmpty()){
            int num=q.poll();
            ar.add(num);
            
            // while(adj.get())
            for(int n:adj.get(num)){
                indeg[n]--;
                if(indeg[n]==0){
                    q.add(n);
                }
            }
        }
        return ar;
    }
}