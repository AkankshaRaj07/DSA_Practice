class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ']' && !st.isEmpty() && st.peek()=='[') st.pop();
            else st.push(c);
        }
        return ((st.size()/2) + 1) / 2;
    }
}