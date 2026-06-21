class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int i : costs) max = Math.max(max, i);
        int[] count = new int[max + 1];
        for (int i : costs) count[i]++;
        int ans = 0;
        for (int cost = 1; cost <= max; cost++) {
            while (count[cost] > 0 && coins >= cost) {
                coins -= cost;
                count[cost]--;
                ans++;
            }
        }
        return ans;
    }
}