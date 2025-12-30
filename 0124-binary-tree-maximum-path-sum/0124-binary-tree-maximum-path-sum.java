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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int leftSum = Math.max(dfs(root.left),0);
        int rightSum = Math.max(dfs(root.right),0);
        maxSum = Math.max(maxSum, leftSum + rightSum +root.val);
        return root.val+ Math.max(leftSum, rightSum );
    }

}