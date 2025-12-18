/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }

    // Visit each node as potential "peak"
    private void traverse(TreeNode node) {
        if (node == null) return;

        int left = maxDown(node.left);
        int right = maxDown(node.right);

        // Path passing through this node
        int currentPath = node.val + left + right;
        max = Math.max(max, currentPath);

        traverse(node.left);
        traverse(node.right);
    }

    // Maximum downward path starting from this node
    private int maxDown(TreeNode node) {
        if (node == null) return 0;

        int left = maxDown(node.left);
        int right = maxDown(node.right);

        // We take max child contribution OR stop at node
        return Math.max(0, node.val + Math.max(left, right));
    }
}
