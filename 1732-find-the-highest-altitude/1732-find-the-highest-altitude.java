class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0;
        int newAlt = 0;
        for(int i: gain){
            newAlt += i;
            alt = Math.max(alt,newAlt);
        }
        return alt;
    }
}