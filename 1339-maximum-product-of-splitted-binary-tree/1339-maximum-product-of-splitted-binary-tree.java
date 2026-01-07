class Solution {
    long product = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        long totalSum = sum(root);
        dfs(root, totalSum);
        return (int)(product % MOD);
    }

    // postorder DFS: returns subtree sum
    private long dfs(TreeNode root, long totalSum) {
        if (root == null) return 0;

        long left = dfs(root.left, totalSum);
        long right = dfs(root.right, totalSum);

        long subTreeSum = left + right + root.val;

        product = Math.max(product, subTreeSum * (totalSum - subTreeSum));

        return subTreeSum;
    }

    private long sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
