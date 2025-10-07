class Solution {
    public boolean isPalindrome(String s) {
        int n= s.length();
        int i= 0;
        return rec(i,s.toLowerCase(),n-1);
    }
    public boolean rec(int i, String s, int n){
        while(i<n && !Character.isLetterOrDigit(s.charAt(i))) i++;
        while(i<n && !Character.isLetterOrDigit(s.charAt(n))) n--;
        if(i>=n) return true;
        if(s.charAt(i) != s.charAt(n)){
            return false;
        }
        return rec(i+1, s, n-1);
    }
}