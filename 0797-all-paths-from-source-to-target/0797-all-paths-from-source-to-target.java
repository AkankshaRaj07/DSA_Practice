class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int m = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, ans, path, 0, m-1);
        return ans;
    }
    public static void dfs(int[][] graph, List<List<Integer>> ans,List<Integer> path, int s, int d) {
        if (s == d) {
            ans.add(new ArrayList <> (path));
            return;
        }
        for (int i = 0; i < graph[s].length; i++) {
            int curr = graph[s][i];
            path.add(curr);
            dfs(graph, ans, path, curr, d);
            path.remove(path.size()-1);
        }
        return ;
    }
}