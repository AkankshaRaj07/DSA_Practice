class Solution {
    public int minAddToMakeValid(String s) {
        Stack <Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c==')' && !st.isEmpty() && st.peek()=='(') st.pop();
            else st.push(c);
        }
        int open = 0, close = 0;
        while(!st.isEmpty()){
            char val = st.pop();
            if(val=='(') open++;
            else close++;
        }
        int ans = Math.abs(open+close);
        return ans;
    }
}