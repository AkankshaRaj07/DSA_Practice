class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        if(s.charAt(0) =='0') return 0;
        return solve(0,s,dp);
    }

    public int solve(int i, String s, int [] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if(dp[i]!=-1) return dp[i];
        int check = 0;
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                check = solve(i + 2, s,dp);
            }
        }
        return dp[i] = solve(i + 1, s,dp) + check;
    }
}