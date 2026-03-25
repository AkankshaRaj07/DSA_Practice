class Solution {
    public boolean isValid(String a) {
        Stack<Character> s = new Stack<>();
        for(char c: a.toCharArray()){
            if(c == '(' || c == '{' || c == '[') s.push(c);
            else if(s.isEmpty()) return false;
            else if(c == ')' && s.peek() == '(') s.pop();
            else if(c == '}' && s.peek() == '{') s.pop();
            else if(c == ']' && s.peek() == '[') s.pop();
            else return false;
        }
        return s.isEmpty();
    }
}