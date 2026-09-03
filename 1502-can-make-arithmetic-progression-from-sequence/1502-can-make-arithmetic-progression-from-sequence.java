class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int cd = arr[1]-arr[0];
        for(int i = 2; i<arr.length; i++){
            int diff = arr[i]-arr[i-1];
            if(diff!=cd ) return false;
        }
        return true;
    }
}