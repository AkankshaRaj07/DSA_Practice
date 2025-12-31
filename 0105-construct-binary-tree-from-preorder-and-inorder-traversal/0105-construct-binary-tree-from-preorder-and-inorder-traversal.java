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
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode build (int[] preorder, int[] inorder, int L, int R){
        if (L > R) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = L;
        while (inorder[mid] != rootVal) {
            mid++;
        }
        root.left = build(preorder, inorder, L, mid - 1);
        root.right = build(preorder, inorder, mid + 1, R);
        return root;

    }
}