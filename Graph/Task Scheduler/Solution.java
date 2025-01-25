class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<tasks.length;i++){
            hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
        }
        for (Map.Entry<Character, Integer> e : hm.entrySet()) {
            pq.add(e.getValue());
        }

        while (!pq.isEmpty()) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int i =1;i<=n+1; i++) {
                if (!pq.isEmpty()) {
                    int freq = pq.poll();
                    freq--;
                    al.add(freq);
                }
            }
            for (int j : al) {
                if(j>0){
                    pq.add(j);
                }
            }

            if (!pq.isEmpty()) {
                count += n + 1;
            } else {
                count += al.size();
            }
        }
        return count;
    }
}