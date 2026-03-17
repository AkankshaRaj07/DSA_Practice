class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        int left = 0;
        for(int i = 0; i<s.length() ; i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            len= Math.max(len,i-left+1);
        }
        return len;
    }
}