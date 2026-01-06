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
    public int maxLevelSum(TreeNode root) {
        int minLev= 0;
        int maxSum=Integer.MIN_VALUE;;
        if (root == null) return minLev;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currLev=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            int currSum=0;
            for(int i =0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null ) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                currSum+=node.val;
                 //if(currSum<0) currSum=0;
            }
            if(currSum>maxSum){
                    maxSum=currSum;
                    minLev=currLev;
                }
            currLev++;
        }
        return minLev;
    }
}