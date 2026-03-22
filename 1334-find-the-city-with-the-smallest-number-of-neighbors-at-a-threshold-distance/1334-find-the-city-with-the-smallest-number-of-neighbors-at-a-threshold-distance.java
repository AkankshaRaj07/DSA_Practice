class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        int resultCity = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{i, 0});
            dist[i] = 0;
            while(!q.isEmpty()){
                int[] curr = q.poll();
                int node = curr[0];
                int d = curr[1];
                for(int[] nei : graph.get(node)){
                    int next = nei[0];
                    int w = nei[1];
                    int newDist = d + w;
                    if(newDist <= distanceThreshold && newDist < dist[next]){
                        dist[next] = newDist;
                        q.offer(new int[]{next, newDist});
                    }
                }
            }
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j && dist[j] <= distanceThreshold)
                    count++;
            }
            if(count <= minCount){
                minCount = count;
                resultCity = i;
            }
        }
        return resultCity;
    }
}