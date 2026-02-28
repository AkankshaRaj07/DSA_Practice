class Solution {
    public int concatenatedBinary(int n) {
        
        long mod = 1_000_000_007;
        long ans = 0;
        int length = 0;
        
        for (int i = 1; i <= n; i++) {
            
            // If i is power of 2 → increase bit length
            if ((i & (i - 1)) == 0) {
                length++;
            }
            
            // Left shift and add current number
            ans = ((ans << length) + i) % mod;
        }
        
        return (int) ans;
    }
}