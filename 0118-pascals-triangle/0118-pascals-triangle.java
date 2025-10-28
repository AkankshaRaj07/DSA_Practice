class Solution {
    public List<List<Integer>> generate(int numRows) {
        List <List <Integer>> ans = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            int val=1; 
            for (int j = 0; j <= i; j++) {
                row.add(val);
                // update to next nCr: val = val * (n - r) / (r + 1)
                val = val * (i - j) / (j + 1);
                
            }
            ans.add(row);
        }return ans;

}}