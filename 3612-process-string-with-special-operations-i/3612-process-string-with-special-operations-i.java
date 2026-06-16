class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for(char a : s.toCharArray()){
            if(a=='*'){
                if(result.length()>0) result.deleteCharAt(result.length()-1);
                continue;
            } 
            else if (a=='#') result.append(result);
            else if(a=='%') result = result.reverse();
            else result.append(a);
        }
        return result.toString();
    }
}