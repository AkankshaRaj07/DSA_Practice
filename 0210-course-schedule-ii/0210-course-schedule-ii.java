class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        boolean [] vis = new boolean[numCourses];
        boolean [] rec = new boolean[numCourses];
        Stack <Integer> st = new Stack<>();
        for(int i =0; i<numCourses; i++){
            if(!vis[i]) {
                if(!dfs(i,adj,vis,rec,st)) return new int[0];
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }
        return ans;
    }
    public boolean dfs(int i, List<List<Integer>> adj, boolean [] vis, boolean [] rec,Stack<Integer> st){
        vis[i] = true;
        rec[i] = true;
        for(int j=0; j < adj.get(i).size(); j++){
            int neighbour =  adj.get(i).get(j);
            if(rec[neighbour]) return false;
            if (!vis[neighbour])  if(!dfs(neighbour, adj, vis, rec,st)) return false;
        }
        rec[i]= false;
        st.push(i);
        return true; 
    }
}