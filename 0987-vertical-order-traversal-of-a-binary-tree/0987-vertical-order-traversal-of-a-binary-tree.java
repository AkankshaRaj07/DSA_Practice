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
    class Custom{
        TreeNode node;
        int row;
        int col;
        Custom(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Custom> queue= new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.offer(new Custom(root,0,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                Custom customNode = queue.poll();
                TreeNode newNode= customNode.node;
                int col=customNode.col;
                int row=customNode.row;
                if(!map.containsKey(col)){
                     TreeMap<Integer, PriorityQueue<Integer>> innerMap= new TreeMap<>();
                     PriorityQueue<Integer> values = new PriorityQueue<>();
                     values.offer(newNode.val);
                     innerMap.put(row,values);
                     map.put(col,innerMap);
                }
                else{
                    if(!map.get(col).containsKey(row)){
                        PriorityQueue<Integer> values = new PriorityQueue<>();
                        values.offer(newNode.val);
                        map.get(col).put(row,values);
                    }
                    else{
                        map.get(col).get(row).offer(newNode.val);
                    }
                }
                if(newNode.left!=null) queue.offer(new Custom(newNode.left,row+1,col-1));
                if(newNode.right!=null) queue.offer(new Custom(newNode.right,row+1,col+1));
            }
        }
        for(Map.Entry<Integer,TreeMap<Integer, PriorityQueue<Integer>>> entry: map.entrySet()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq: entry.getValue().values() ){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }   
            }
            ans.add(list);
        }
        return ans;
    }
}