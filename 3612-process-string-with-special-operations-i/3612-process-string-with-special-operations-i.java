class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for(char a : s.toCharArray()){
            if(a=='*'){
                if(result.length()>0) result.deleteCharAt(result.length()-1);
                continue;
            } 
            else if (a=='#') result.append(result);
            else if(a=='%') result = rev(result);
            else result.append(a);
        }
        return result.toString();
    }
    public StringBuilder rev(StringBuilder s){
        StringBuilder reverse = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            reverse.append(s.charAt(i));
        }
        return reverse;
    }
}