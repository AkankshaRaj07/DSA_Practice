class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (res.length() > 0 && k > 0 && res.charAt(res.length() - 1) > c) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            res.append(c);
        }
        while (k > 0) {
            res.deleteCharAt(res.length() - 1);
            k--;
        }

        // Remove leading zeros
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.length() == 0 ? "0" : res.toString();

    }
    // public String removeKdigits(String num, int k) {
    //     Stack<Character> st= new Stack<>();
    //     for(char dig: num.toCharArray()){
    //         while(!st.isEmpty() && k>0 && st.peek() > dig){
    //             st.pop();
    //             k--;
    //         }
    //         st.push(dig);
    //     }
    //     while(k>0 && !st.isEmpty()){
    //         st.pop();
    //         k--;
    //     }
    //     StringBuilder sb= new StringBuilder();
    //     while(!st.isEmpty()){
    //         sb.append(st.pop());
    //     }
    //     sb.reverse();
    //     while(sb.length() > 0 && sb.charAt(0) == '0'){
    //         sb.deleteCharAt(0);
    //     }
    //     return sb.length() > 0 ? sb.toString() : "0";
    // }
}