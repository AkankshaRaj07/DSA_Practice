class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        int[][] q = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        int[] cnt = new int[n + 1];
        int[] ans = new int[queries.length];
        int l = 0, r = 0, active = 0;
        for (int[] query : q) {
            int t = query[0];
            while (r < logs.length && logs[r][1] <= t) {
                if (cnt[logs[r][0]]++ == 0) active++;
                r++;
            }
            while (l < r && logs[l][1] < t - x) {
                if (--cnt[logs[l][0]] == 0) active--;
                l++;
            }
            ans[query[1]] = n - active;
        }
        return ans;
    }
}
