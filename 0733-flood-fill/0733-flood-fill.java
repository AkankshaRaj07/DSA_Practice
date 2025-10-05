class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r= image.length;
        int c= image[0].length; 
        Queue<int[]> q= new LinkedList<>();
        int curColor = image[sr][sc];
        q.offer(new int []{sr,sc});
        image[sr][sc]= color;
        while(!q.isEmpty()){
            int node[] = q.poll();
            int i=node[0];
            int j= node[1];
            int adjList[][] = {{i-1,j},{i,j-1},{i+1,j},{i,j+1}};
            for(int k[]: adjList){
                int m= k[0];
                int n= k[1];
                if(m<0 || n<0 || m>=r || n>=c || image[m][n] != curColor || image[m][n]==color){
                    continue;
                }
                q.offer(new int[]{m,n});
                image[m][n] = color;
            }
        }
        return image;


    }
}