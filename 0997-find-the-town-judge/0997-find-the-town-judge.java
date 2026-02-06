class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length==0) return 1;
        int  ans =0;
        int [] incoming =new int [n+1];
        int [] outgoing = new int [n+1];
        for(int i =0; i<trust.length ; i++){
            incoming[trust[i][1]]++;
            outgoing[trust[i][0]]++;
        }
        for(int i =0; i<=n; i++){
            if(incoming[i]==n-1 && outgoing[i]==0) return i;
        }
        return -1;
    }
}