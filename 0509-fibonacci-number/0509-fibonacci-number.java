class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int prev = 0;
        int next = 1;
        for(int i = 2; i<=n; i++){
            int temp = prev+next;
            prev=next;
            next = temp;
        }
        return next;
    }
}