class Solution {
    public int operate(int a, int b, String s){
        if(s.equals("+")) return a + b;
        else if(s.equals("-")) return a - b;
        else if(s.equals("*")) return a * b;
        else return a / b;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer>  st = new Stack<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") ||
               s.equals("*") || s.equals("/")){
                int b = st.pop();
                int a = st.pop();
                int result = operate(a,b,s);
                st.push(result);
            }else st.push(Integer.parseInt(s));
        }
        return st.peek();
    }
}