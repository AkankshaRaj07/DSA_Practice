class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        HashSet <Integer> toRemove = new HashSet<>();
        for(int i = 0; i<s.length() ; i++){
            char c  = s.charAt(i);
            if(c=='(') st.push(i);
            else if (c==')'){
                if(st.isEmpty()) toRemove.add(i);
                else st.pop();
            }
        }
        while(!st.isEmpty()) toRemove.add(st.pop());
        String validString ="";
        for(int i = 0; i<s.length(); i++){
            if(toRemove.contains(i)) continue;
            else validString+=s.charAt(i);
        }
        return validString;
    }
}