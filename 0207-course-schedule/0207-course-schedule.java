class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i< prerequisites.length; i++){
            int courses = prerequisites[i][0];
            int pre = prerequisites[i][1];
            adj.get(courses).add(pre);
        }
        boolean [] vis = new boolean [numCourses];
        boolean [] rec = new boolean [numCourses];
        for(int i = 0; i< adj.size() ; i++){
            if(!vis[i]){
                if(!dfs(i, adj, vis, rec)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int i, List<List<Integer>> adj, boolean [] vis, boolean [] rec ){
        if(vis[i]) return true;
        vis[i] = true;
        rec[i] = true;
        for(int j=0; j < adj.get(i).size(); j++){
            int neighbour =  adj.get(i).get(j);
            if(rec[neighbour]) return false;
            if(!dfs(neighbour, adj, vis, rec)) return false;
        }
        rec[i]= false;
        return true; 
    }
}