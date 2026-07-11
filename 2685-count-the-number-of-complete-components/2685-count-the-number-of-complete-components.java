import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        
        for(int[] e : edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                vis[i] = true;

                int nodes = 0;
                int degreeSum = 0;

                while(!q.isEmpty()){
                    int curr = q.poll();
                    nodes++;
                    degreeSum += list.get(curr).size();

                    for(int neigh : list.get(curr)){
                        if(!vis[neigh]){
                            vis[neigh] = true;
                            q.offer(neigh);
                        }
                    }
                }

                // edges = degreeSum / 2
                if(degreeSum == nodes * (nodes - 1)){
                    count++;
                }
            }
        }

        return count;
    }
}