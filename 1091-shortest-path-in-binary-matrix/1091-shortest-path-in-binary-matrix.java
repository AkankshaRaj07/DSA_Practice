class Solution {
    class Pair{
        int i;
        int j;
        int dist;
        Pair(int a, int b, int distance){
            this.i=a;
            this.j=b;
            this.dist=distance;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,1));
        boolean [][] vis = new boolean [n][n];
        vis[0][0]= true;
        int [][]  directions= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        while(!q.isEmpty()){
            Pair curr= q.poll();
            int i = curr.i;
            int j = curr.j;
            int dis = curr.dist;
            if(i==n-1 && j==n-1) return dis;
            for(int [] dir: directions){
                int nr=i+dir[0];
                int nc=j+dir[1];
                if(nr>=0 && nc>=0 && nc<n && nr<n && grid[nr][nc]==0 && !vis[nr][nc]){
                    vis[nr][nc]= true;
                    q.offer(new Pair (nr,nc,dis+1));
                }
            }
        }
        return -1;
    }
}