class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        String res = "";
        int open = 0; 
        for(char c: s.toCharArray()){
            if(c >='a' && c<='z') res+=c;
            else if (c=='('){
                open++;
                res+=c;
            }
            else if(open>0){
                open--;
                res+=c;
            }
        }
        String ans ="";
        
            int close = 0;
            
            for(int i = res.length()-1; i>=0; i--){
                char c = res.charAt(i);
                if(c>='a' && c<='z') ans+=c;
                else if(c==')'){
                    close++;
                    ans+=c;
                }
                else if(close>0){
                    close--;
                    ans+=c;
                }
            }
        
        return new StringBuilder(ans).reverse().toString();

    }
}