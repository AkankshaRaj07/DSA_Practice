class StockSpanner {
    class Stock{
        int val;
        int span;
        Stock(int val, int span){
            this.val = val ;
            this.span = span;
        }
    }
    Stack<Stock> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    public int next(int price) {
        int span =1;
        while(!st.isEmpty() && st.peek().val<=price){
            span +=st.peek().span;
            st.pop();
        }
        st.push(new Stock(price,span));
        return st.peek().span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */