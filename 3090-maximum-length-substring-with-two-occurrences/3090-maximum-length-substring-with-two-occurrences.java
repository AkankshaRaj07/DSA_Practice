class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                if(valid(s.substring(i,j+1))) maxLen= Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
    public boolean valid(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(char a: s.toCharArray()){
             map.put(a,map.getOrDefault(a,0)+1);
             if (map.get(a)>2) return false;
        }
        return true;
    }
}