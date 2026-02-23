class Solution {
    public boolean hasAllCodes(String s, int k) {
         int n = s.length();
        int need = 1 << k;
        boolean[] seen = new boolean[need];
        int mask = need - 1;
        int num = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            num = ((num << 1) & mask) | (s.charAt(i) - '0');
            if (i >= k - 1) {
                if (!seen[num]) {
                    seen[num] = true;
                    count++;
                    if (count == need) return true;
                }
            }
        }
        return false;
    }
}