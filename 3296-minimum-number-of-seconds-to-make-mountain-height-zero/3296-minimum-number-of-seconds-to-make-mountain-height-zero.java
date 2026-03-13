class Solution {
    public long minNumberOfSeconds(int H, int[] w) {
        long l=0,r=(long)1e18;
        while(l<r){
            long m=l+(r-l)/2;
            if(ok(m,H,w)) r=m;
            else l=m+1;
        }
        return l;
    }
    boolean ok(long T,int H,int[] w){
        long sum=0;
        for(int t:w){
            long v=(2*T)/t;
            long x=(long)((Math.sqrt(1+4*v)-1)/2);
            sum+=x;
            if(sum>=H) return true;
        }
        return false;
    }
}