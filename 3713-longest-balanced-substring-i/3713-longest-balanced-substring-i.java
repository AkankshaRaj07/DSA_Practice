class Solution {
    public int longestBalanced(String s) {
        int ans=0;
        for(int i = 0; i < s.length(); i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j = i; j < s.length(); j++){
               map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
               if(isBalanced(map)){
                    ans = Math.max(ans, j - i + 1);
                }

            }
        }
        return ans;
    }
    private boolean isBalanced(HashMap<Character,Integer> map){
        int freq = -1;
        for(int val : map.values()){
            if(freq == -1) freq = val;
            else if(freq != val) return false;
        }
        return true;
    }
}