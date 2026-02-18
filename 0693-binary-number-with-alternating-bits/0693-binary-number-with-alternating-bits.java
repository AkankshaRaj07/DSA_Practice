class Solution {
    public boolean hasAlternatingBits(int n) {
        int test = n ^ (n>>1);
        return (test & (test + 1)) ==0;
    }
}