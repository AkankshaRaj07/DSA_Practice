class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char a: s.toCharArray()){
            if(a=='*')st.pop();
            else st.push(a);
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.append(st.pop());
        return ans.reverse().toString();
    }
}