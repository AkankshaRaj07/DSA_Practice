class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> vis = new HashSet<>();
        int provinces=0;
        for(int i=0; i<isConnected.length; i++){
            if(!vis.contains(i)){
                dfs(i, isConnected , vis);
                provinces++;
            }
        }
        return provinces;
    }
    public void dfs(int city, int [][] isConnected, Set<Integer> vis){
        vis.add(city);
        for(int i=0; i< isConnected[city].length; i++){
            if( isConnected[city][i] == 1 && !vis.contains(i)){
                dfs(i,isConnected, vis);
            }
        }
    }
}