class Solution {

    public boolean isMatch(String s, String p) {

        int[][] dp = new int[s.length()][p.length()];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return rec(s,p,s.length()-1,p.length()-1,dp);
    }

    boolean rec(String s,String p,int i,int j,int[][] dp){

        if(i < 0 && j < 0) return true;

        if(j < 0) return false;

        if(i < 0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*')
                    return false;
            }
            return true;
        }

        if(dp[i][j]!=-1)
            return dp[i][j]==1;

        boolean ans;

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            ans = rec(s,p,i-1,j-1,dp);
        }
        else if(p.charAt(j)=='*'){
            ans = rec(s,p,i,j-1,dp)
                    || rec(s,p,i-1,j,dp);
        }
        else{
            ans = false;
        }

        dp[i][j]=ans?1:0;

        return ans;
    }
}