class Solution {
    public int minCost(int n, int[][] edges) {
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        // Build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new int[]{v, w});       // original edge
            graph.get(v).add(new int[]{u, 2 * w});   // reversed edge
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if (node == n - 1)
                return cost;
            
            if (cost > dist[node])
                continue;
            
            for (int[] nei : graph.get(node)) {
                int next = nei[0];
                int wt = nei[1];
                
                if (dist[next] > cost + wt) {
                    dist[next] = cost + wt;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        
        return -1;
    }
}
