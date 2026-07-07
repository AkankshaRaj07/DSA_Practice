class Solution {
    public long sumAndMultiply(int n) {
        int x = 0, sum = 0;
        while (n > 0) {
            int rem = n % 10;
            if (rem != 0) {
                x = (x * 10) + rem;
                sum += rem;
            }
            n /= 10;
        }
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return (long) rev * sum;
    }
}