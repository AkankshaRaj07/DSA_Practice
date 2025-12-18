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

    private int dfs(TreeNode root){
        //System.out.println("root.val is " + root.val );
        if(root == null) return 0;
        int sumLeft = Math.max(dfs(root.left),0);
        int sumRight = Math.max(dfs(root.right),0);
        maxSum = Math.max(maxSum,sumLeft + root.val + sumRight);
        return Math.max(sumLeft + root.val,sumRight + root.val);
    }
}