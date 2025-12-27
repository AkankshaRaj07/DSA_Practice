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
    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        if (node == null)
            return result;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = node;
        queue.addFirst(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (!reverse) {
                    TreeNode currNode = queue.removeFirst();
                    curr.add(currNode.val);
                    if (currNode.left != null)
                        queue.addLast(currNode.left);
                    if (currNode.right != null)
                        queue.addLast(currNode.right);
                } else {
                    TreeNode currNode = queue.removeLast();
                    curr.add(currNode.val);
                    if (currNode.right != null)
                        queue.addFirst(currNode.right);
                    if (currNode.left != null)
                        queue.addFirst(currNode.left);
                }

            }
            result.add(curr);
            reverse = !reverse;
        }
        return result;
    }
}