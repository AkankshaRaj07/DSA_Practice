class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length() ; i++){
            char c = s.charAt(i);
            StringBuilder temp = new StringBuilder();
            if(c == '(') st.push(c); 
            else if(Character.isLetter(c)) st.push(c);
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    temp.append(st.pop());
                }
                st.pop();
                for(char a: temp.toString().toCharArray()) st.push(a);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.append(st.pop());
        return ans.reverse().toString();
    }
    // public String reverse(String res, int start){
    //     String first = res.substring(0, start);
    //     String second = new StringBuilder(res.substring(start)).reverse().  toString();
    //     return first + second;
        
    // }
}