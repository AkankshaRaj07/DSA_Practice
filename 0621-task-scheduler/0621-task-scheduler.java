class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char a: tasks) freq[a-'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        for(int a: freq) if(a>0) pq.offer(a);
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 1; i<=n+1; i++){
                if(!pq.isEmpty()){
                    int a = pq.poll();
                    a--;
                    temp.add(a);
                }
            }
            for(int a: temp)if(a>0) pq.offer(a);
            if(pq.isEmpty()) time+=temp.size();
            else time+=n+1;
        }
        return time;
    }
}