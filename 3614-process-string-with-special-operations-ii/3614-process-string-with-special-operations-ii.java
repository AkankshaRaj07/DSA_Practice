class Solution {
    public char processStr(String s, long k) {
        long l = 0;
        for(char a: s.toCharArray()){
            if(a=='*'){
                if(l>0) l--;
            }
            else if(a=='#') l=l*2;
            else if(a=='%') continue;
            else l++;
        }
        if(k>=l) return '.';
        for(int i = s.length()-1; i>=0; i--){
            char a = s.charAt(i);
            if(a=='*') l++;
            else if(a=='#'){
                l=l/2;
                if(k>=l) k=k-l;
            }
            else if (a=='%')k=l-k-1;
            else l--;
            if(k==l) return a;
        }
        return '.';
    }
}
