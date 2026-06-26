class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        String res = "";
        int br =0;
        for(int i = 0; i<s.length() ; i++){
            char c = s.charAt(i);
            if(c == '(') st.push(res.length()); 
            else if(c>='a' && c<='z') res+=c;
            else if(c==')'){
                int start = st.pop();
                res = reverse(res, start);
            }
        }
        return res;
    }
    public String reverse(String res, int start){
        String first = res.substring(0, start);
        String second = new StringBuilder(res.substring(start)).reverse().  toString();
        return first + second;
        
    }
}