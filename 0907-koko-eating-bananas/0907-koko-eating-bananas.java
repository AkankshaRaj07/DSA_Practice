class Solution {
    public int getMax(int [] piles){
        int max= Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            max=(Math.max(piles[i],max));
        }
        return max;
    }
    public int totalh(int [] piles, int h){
        int toth=0;
        for(int i=0; i<piles.length; i++){
            toth+= Math.ceil((double)piles[i]/(double) h);
        }
        return toth;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=getMax(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int th=totalh(piles, mid);
            if(th<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            
        }
        return low;
    }
}