class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Integer [][] dp = new Integer [m][n];
        return dfs(0,0,m,n,nums1,nums2,dp);
    }
    public int dfs(int i, int j, int m, int n, int[] nums1, int[] nums2, Integer [][] dp){
        if(i==m || j==n) return Integer.MIN_VALUE;
        if(dp[i][j] != null) return dp[i][j];

        int take = nums1[i]*nums2[j];
        int next = dfs(i+1,j+1,m,n,nums1,nums2,dp);
        if(next>0) take+=next;
        int skip1= dfs(i+1,j,m,n,nums1,nums2,dp);
        int skip2= dfs(i,j+1,m,n,nums1,nums2,dp);
        return dp[i][j] = Math.max(take, Math.max(skip1,skip2));
    }
}