class Solution {
    class Stock{
        int val;
        int span;
        Stock(int val, int span){
            this.val = val ;
            this.span = span;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Stock> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek().val <= temperatures[i]){
                st.pop();
            }
            if(!st.isEmpty()) ans[i] = st.peek().span - i;
            st.push(new Stock(temperatures[i],i));
        }
        return ans;
    }
}