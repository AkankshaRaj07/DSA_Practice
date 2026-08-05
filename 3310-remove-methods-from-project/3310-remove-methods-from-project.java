class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int [] i : invocations){
            adj.get(i[0]).add(i[1]);
        }
        int[] vis = new int[n];
        dfs(vis, adj, k);
        boolean flag = true;
        for(int[] a: invocations){
            if(vis[a[0]] != 2 && vis[a[1]] == 2) flag = false;
        }
        List<Integer> ans = new ArrayList<>();
        if(!flag) {
            for(int i = 0; i<n; i++) ans.add(i);
        }
        else {
            for(int i = 0; i<n; i++) if(vis[i]!=2) ans.add(i);
        }
        return ans;
    }
    public void dfs(int[] vis , List<List<Integer>> adj, int k){
        vis[k] = 2;
        for(int neighbours: adj.get(k)){
            if(vis[neighbours]==0) dfs(vis,adj,neighbours);
        }
    }
}