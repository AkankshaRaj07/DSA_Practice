class Solution {
    public int smallestNumber(int n, int t) {
        boolean flag = true;
        if(product(n)%t == 0) return n;
        while(flag){
            n++;
            int p = product(n);
            if(p%t == 0) {
                flag = false;
            }
            
        }
        return n;
    }
    private int product(int a){
        int p = 1;
        while(a>0){
            p*= (a%10);
            a/=10;
        }
        return p;
    }
}