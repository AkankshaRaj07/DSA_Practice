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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList <Integer> list= new LinkedList();
        trav(root, list);
        return list;
    }
    public void trav(TreeNode root, LinkedList <Integer> list){
        if( root == null) return;
        trav(root.left, list);
        list.add(root.val);
        trav(root.right, list);

    }
}