class Solution {
    public int minimumDeletions(String s) {
        int ans = 0;
        int count = 0;
        for(char c: s.toCharArray()){
            if(c=='b') count ++;
            else if(count !=0){
                ans++;
                count--;
            }
        }
        return ans;
    }
}