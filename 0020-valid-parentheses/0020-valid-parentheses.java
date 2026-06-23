class Solution {
    public boolean isValid(String a) {
        Stack<Character> s = new Stack<>();
        for(char c: a.toCharArray()){
            if(c == '(') s.push(')');
            else if (c == '{') s.push('}');
            else if (c =='[') s.push(']');
            else if(s.isEmpty() || s.peek()!=c) return false;
            else s.pop();
        }
        return s.isEmpty();
    }
}