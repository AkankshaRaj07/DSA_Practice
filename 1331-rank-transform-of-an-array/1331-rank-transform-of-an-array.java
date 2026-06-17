class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: arr)pq.offer(i);
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        while(!pq.isEmpty()){
            int x=pq.poll();
            if(!map.containsKey(x)){
                map.put(x,rank++);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr; 
    }
}