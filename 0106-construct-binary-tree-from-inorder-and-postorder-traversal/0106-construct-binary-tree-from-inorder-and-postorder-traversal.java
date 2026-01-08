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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int is = 0;
        int ie = inorder.length-1;
        int ps = 0;
        int pe = postorder.length-1;
        return dfs(inorder, postorder, map, is, ie, ps, pe);
    }

    public TreeNode dfs(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int is, int ie, int ps, int pe){
        if(is>ie || ps>pe) return null;
        TreeNode node = new TreeNode(postorder[pe]);
        int find= map.get(node.val);
        node.left = dfs(inorder,postorder,map, is, find-1, ps, ps+find-is-1);
        node.right = dfs(inorder,postorder,map, find+1, ie, ps+find-is, pe-1);
        return node;
    }
}