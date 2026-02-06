class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int m= rooms.size();
        int n= rooms.get(0).size();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean [] vis = new boolean [m];
        vis[0]= true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0; i<rooms.get(curr).size(); i++){
                int temp=rooms.get(curr).get(i);
                if(!vis[temp]){
                    vis[temp]=true;
                    q.offer(temp);
                }
            }
        }
        for(boolean a: vis){
            if(!a) return false ;
        }
        return true;
    }
}