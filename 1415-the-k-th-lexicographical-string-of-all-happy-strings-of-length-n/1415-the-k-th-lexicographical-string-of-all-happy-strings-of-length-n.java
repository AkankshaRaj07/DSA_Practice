class Solution {
    int count = 0;
    String ans = "";

    public String getHappyString(int n, int k) {
        dfs(n, k, new StringBuilder(), ' ');
        return ans;
    }

    private void dfs(int n, int k, StringBuilder sb, char prev) {

        if (sb.length() == n) {
            count++;
            if (count == k) {
                ans = sb.toString();
            }
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {

            if (ch == prev) continue;

            sb.append(ch);
            dfs(n, k, sb, ch);

            if (!ans.equals("")) return;   // early stop
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}