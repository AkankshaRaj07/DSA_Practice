class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            while(map.size()==3){
                char lefty= s.charAt(left);
                map.put(lefty, map.get(lefty)-1);
                if(map.get(lefty)==0) map.remove(lefty);
                left++;
            }
            ans+=left;
        }
        return ans;
    }
}

