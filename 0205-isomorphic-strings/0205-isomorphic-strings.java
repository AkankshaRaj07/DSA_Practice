class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> chars= new HashMap<>();
        HashMap<Character, Integer> chart= new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!chars.containsKey(s.charAt(i))){
                chars.put(s.charAt(i),i);
            }
            if(!chart.containsKey(t.charAt(i))){
                chart.put(t.charAt(i),i);
            }
            if(!chars.get(s.charAt(i)).equals(chart.get(t.charAt(i)))) return false;
        }
        return true;
    }
}