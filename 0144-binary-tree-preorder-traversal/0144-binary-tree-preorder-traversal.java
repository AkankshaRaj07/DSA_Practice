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
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list=new LinkedList();
        traverse(root, list);
        return list;
    }
    public void traverse(TreeNode root, LinkedList<Integer> list){
        if(root ==  null) return;
        list.add(root.val);
        traverse(root.left,list);
        traverse(root.right,list);
    }
}