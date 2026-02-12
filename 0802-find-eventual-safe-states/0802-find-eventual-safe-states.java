class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int [] vis = new int [graph.length];
        for(int i=0; i<graph.length; i++) if(graph[i].length == 0) vis[i]=2;
        for(int i =0; i<graph.length; i++) dfs(i,graph,vis);
        for(int i =0; i<vis.length; i++) if(vis[i]==2) ans.add(i);
        return ans;
    }
    public boolean dfs(int i, int[][] graph, int [] vis){
        if(vis[i]==1) return false;
        if(vis[i]==2) return true;
        vis[i]=1;
        for(int neighbour:graph[i]) if(!dfs(neighbour,graph,vis)) return false;
        vis[i]=2;
        return true;
    }
}