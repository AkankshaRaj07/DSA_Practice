class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int num:map.keySet()){
            pq.offer(new int[]{num,map.get(num)});
            if(pq.size()>k) pq.poll();
        }
        int[] ans=new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll()[0];
        }
        return ans;
    }
}