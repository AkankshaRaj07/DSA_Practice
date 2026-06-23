class Solution {
    class Pair{
        char c;
        int freq;
        Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(char a: s.toCharArray()){
            if(!st.isEmpty() && st.peek().c==a){
                st.push(new Pair(a,st.peek().freq+1));
                if(st.peek().freq==k){
                    for(int i = 1; i<=k; i++) st.pop();
                }
            }
            else st.push(new Pair(a,1));
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.append(st.pop().c);
        return ans.reverse().toString();
    }
}