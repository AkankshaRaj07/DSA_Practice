class Solution {
    public int climbStairs(int n) {
        if (n<=2) return n;
        int [] dp = new int [n+1];
        //dp[0]=0;
        int prev= 1;
        int next = 2;
        for(int i  = 3; i<=n; i++){
            int temp = prev+next;
            prev = next;
            next = temp;
        }
        return next;
    }
}