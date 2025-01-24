import java.util.*;
class Solution {

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean visited[] = new boolean[isConnected.length + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < isConnected.length; i++) {
            // int src = i + 1;
            // q.add(src);
            // while (!q.isEmpty()) {
            //     src = q.remove();
            //     if (!visited[src]) {
            //         count++;
            //         visited[src] = true;
            //         for (int j = 0; j < isConnected[i].length; j++) {
            //             if (isConnected[i][j] != 0) {
            //                 q.add(j + 1);
            //             }
            //         }
            //     }
            // }
            if (!visited[i]) {
                count++; 
                q.add(i); 
                
                //  BFS
                while (!q.isEmpty()) {
                    int node = q.remove();
                    if (!visited[node]) {
                        visited[node] = true; 
                        for (int j = 0; j < isConnected.length; j++) {
                            if (isConnected[node][j] == 1 && !visited[j]) {
                                q.add(j);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}