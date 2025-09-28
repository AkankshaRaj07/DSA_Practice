class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        //int dp[][] = new int[n][amount + 1];
        int [] prev = new int [amount+1];
        prev[0]=0;
        for (int a = 0; a <= amount; a++) {
                if ((a % coins[0]) == 0) {
                    prev[a] = a / coins[0];
                }
                else prev[a] = (int) 1e9;
        }
        for (int i = 1; i < n; i++) {
            int [] cur= new int [amount+1];
            cur[0]=0;
            for (int a = 0; a <= amount; a++) {
                int pick = (int) (1e9);
                if (a>= coins[i]) {
                    pick = 1 + cur[a - coins[i]];
                }
                int noPick = prev[a];
                cur[a] = Math.min(pick, noPick);
            }
            prev=cur;
        }
        if (prev[amount] == (int) (1e9)){
            prev[amount] = -1;
        }
        return prev[amount];
    }
}