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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair<TreeNode, Long>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0L));
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            long minIndex = queue.peek().getValue(); // normalize
            long first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> pair = queue.poll();
                TreeNode node = pair.getKey();
                long index = pair.getValue() - minIndex;
                if (i == 0) first = index;
                if (i == size - 1) last = index;
                if (node.left != null)
                    queue.offer(new Pair<>(node.left, 2 * index + 1));
                if (node.right != null)
                    queue.offer(new Pair<>(node.right, 2 * index + 2));
            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }
}