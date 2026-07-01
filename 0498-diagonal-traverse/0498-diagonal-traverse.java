class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(mat[i][j]);
            }
        }
        int[] ans = new int[m*n];
        boolean flip = true;
        int j = 0;
        for(int d = 0; d <= m + n - 2; d++){
            ArrayList<Integer> temp = map.get(d);
            if(flip) Collections.reverse(temp);
            for(int a: temp){
                ans[j++]=a;
            }
            flip =!flip;

        }
        return ans;
    }
}