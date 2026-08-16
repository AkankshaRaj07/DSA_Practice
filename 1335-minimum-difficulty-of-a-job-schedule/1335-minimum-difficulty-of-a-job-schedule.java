class Solution {
    int [][] dp = new int[301][11];
    public int minDifficulty(int[] jd, int d) {
        int n = jd.length;
        if(jd.length < d) return -1; 
        for(int [] i : dp) Arrays.fill(i,-1);
        return solve(jd,n,0,d);
    }
    public int solve(int[] jd, int n, int i, int d){
        if(d==1){
            int max = jd[i];
            for(int j = i; j<n; j++) max = Math.max(max,jd[j]);
            return max;
        }
        if(dp[i][d]!=-1) return dp[i][d];
        int maxD = jd[i];
        int ans = Integer.MAX_VALUE;
        for(int j = i; j<=n-d; j++){
            maxD = Math.max(maxD,jd[j]);
            int res = maxD + solve(jd,n, j+1, d-1);
            ans = Math.min(ans,res);
        }
        return dp[i][d] = ans;
    }
}