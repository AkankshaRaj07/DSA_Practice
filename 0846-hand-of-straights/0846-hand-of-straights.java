class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: hand)map.put(a,map.getOrDefault(a,0)+1);
        for(int a : map.keySet()) pq.offer(a);
        while(!pq.isEmpty()){
            int start = pq.peek();
            for(int i = 0; i<groupSize;i++){
                int curr = start+i;
                if(!map.containsKey(curr)) return false;
                map.put(curr,map.get(curr)-1);
                if(map.get(curr)==0) {
                    if(curr!=pq.peek()) return false;
                    pq.poll();
                    map.remove(curr);
                }
            }
        }
        return true;
    }
}