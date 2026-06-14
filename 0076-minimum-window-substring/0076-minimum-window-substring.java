class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char a: t.toCharArray()){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int left = 0,start = 0;
        int need = map.size();
        int minLen = Integer.MAX_VALUE;
        for(int right = 0; right < s.length() ; right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) need--;
            }
            while(need == 0){
                if(right - left +1 <minLen){
                    minLen = right - left +1;
                    start = left;
                }
                char remains = s.charAt(left);
                if(map.containsKey(remains)){
                    map.put(remains, map.get(remains)+1);
                    if(map.get(remains)>0) need++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}