class Solution {
    public int fib(int n) {
        // int dp[] = new int[n+1];
        if(n<=1) return n;
        int prev1=1;
        int prev2=0;
        int ans=0;
        for(int i=2; i<=n; i++){
            ans=prev1+prev2;
            prev2=prev1;
            prev1=ans;
            // dp[i]=dp[i-1]+dp[i-2];
        }
        return ans;
    }
}