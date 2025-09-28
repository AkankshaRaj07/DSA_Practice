class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i=text1.length();
        int j=text2.length();
        int prev[]= new int [j+1];
        //int dp[][]= new int [i+1][j+1];
        prev[0]=0;
        for(int m=1; m<=i; m++){
            int cur[]= new int [j+1];
            cur[0]=0;
            for(int n=1; n<=j; n++){
                if(text1.charAt(m-1)==text2.charAt(n-1)){
                    cur[n]= 1 + prev[n-1];
                }
                else{
                    cur[n]= Math.max(prev[n],cur[n-1]);
                }
            }
            prev=cur;
        }
        return prev[j];
    }
    
}