class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 0});

        for (int[] r : restrictions) list.add(r);

        list.sort((a, b) -> a[0] - b[0]);

        int m = list.size();

        for (int i = 1; i < m; i++) {
            int d = list.get(i)[0] - list.get(i - 1)[0];
            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i - 1)[1] + d);
        }

        for (int i = m - 2; i >= 0; i--) {
            int d = list.get(i + 1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i + 1)[1] + d);
        }

        int ans = 0;

        for (int i = 1; i < m; i++) {
            long x1 = list.get(i - 1)[0], h1 = list.get(i - 1)[1];
            long x2 = list.get(i)[0], h2 = list.get(i)[1];
            ans = (int)Math.max(ans, (h1 + h2 + x2 - x1) / 2);
        }

        int[] last = list.get(m - 1);
        ans = Math.max(ans, last[1] + n - last[0]);

        return ans;
    }
}