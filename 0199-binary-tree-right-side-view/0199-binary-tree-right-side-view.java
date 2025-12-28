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
    public List<Integer> rightSideView(TreeNode root) {
        List <Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = root;
        while(!queue.isEmpty()){
            int size = queue.size();
            int curr=node.val;
            TreeNode currNode=root;
            for(int i=0; i<size; i++){
                currNode =queue.poll();
                if(currNode.left!= null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
            list.add(currNode.val);
            
        }
        return list; 
    }
}