class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: nums){
            pq.offer(a);
        }
        int[] sorted = new int[nums.length];
        for(int i=0; i<nums.length; i++ ){
            sorted[i] = pq.poll();
        }
        return sorted;
    }
}