class Solution {
    String min="";
    public String lexGreaterPermutation(String s, String target) {
        int freq[]  = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        char[] res = new char[target.length()];
        find(0,res,freq,target);
        return min;
    }
    boolean find(int ind, char[] res , int[] freq , String target){
        if(ind==target.length()){
            String ans = new String(res);
            if(ans.compareTo(target)>0){
                min = ans;
                return true;
            }
            return false;
        }
        char tc = target.charAt(ind);
        for(int i = 0 ; i<26 ; i++){
            if(i==tc-'a' && freq[i]>0){
                res[ind] = (char)('a'+i);
                freq[i]--;
                if(find(ind+1,res,freq,target)) return true;
                freq[i]++;
            }
            if(i>tc-'a' && freq[i]>0){
                res[ind] = (char)('a'+i);
                ind++;
                freq[i]--;
                for(int x=0 ; x<26 ; x++){
                    while(freq[x]>0){
                        res[ind] = (char)('a'+x);
                        ind++;
                        freq[x]--;
                    }
                }
                String currs = new String(res);
                min = currs;
                return true;
            }
        }
        return false;
    }
}