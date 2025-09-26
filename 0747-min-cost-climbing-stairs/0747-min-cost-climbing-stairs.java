class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int one=0;
        int two=0;
        int ans=0;
        for(int i=2; i<=n; i++){
            int step1=cost[i-1]+one;
            int step2=cost[i-2]+two;
            ans=Math.min(step1,step2);
            two=one;
            one=ans;
        }
        return ans;
    }
    
}