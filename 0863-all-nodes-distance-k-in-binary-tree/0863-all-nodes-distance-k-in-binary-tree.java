/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null ) return ans;
        HashMap<TreeNode, TreeNode> pm= new HashMap<>();
        getParent(pm,root);
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                TreeNode curr = q.poll();
                visited.add(curr);
                if(k==0){
                    ans.add(curr.val);
                }
                if(pm.containsKey(curr) && !visited.contains(pm.get(curr))){
                    q.offer(pm.get(curr));
                }
                if(curr.left != null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                }
            }
            k--;
            if(k<0) break;
        }
        return ans;
        
    }
    public void getParent(HashMap<TreeNode, TreeNode> pm,TreeNode root){
       if(root == null) return;
       if(root.left != null){
        pm.put(root.left, root);
       }
       if(root.right!= null){
        pm.put(root.right , root);
       }
       getParent(pm,root.left);
       getParent(pm, root.right);
    }
}