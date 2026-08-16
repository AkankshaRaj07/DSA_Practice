class Solution {
    public int maxLength(List<String> arr) {
        String temp = "";
        int n = arr.size();
        return solve(arr,0,n,temp);
    }
    private int solve(List<String> arr, int i , int n, String temp){
        if(i>=n) return temp.length();
        int pick = 0, noPick = 0;
        if(!hasDuplicate(temp, arr.get(i))){
             pick = solve(arr,i+1,n,temp+arr.get(i));
        }
        noPick = solve(arr,i+1,n,temp);
        return Math.max(pick, noPick);
    }
    private boolean hasDuplicate(String s1, String s2){
        int[] freq = new int[26];
        for(char a: s1.toCharArray()){
            if(freq[a-'a']>0) return true;
            freq[a-'a']++;
        }
        for(char a: s2.toCharArray()){
            if(freq[a-'a']>0) return true;
            freq[a-'a']++;
        }
        return false;

    }
}