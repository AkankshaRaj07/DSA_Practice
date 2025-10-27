class Solution {

    public void reverse(int[] arr){
        for(int i=0; i<arr.length/2; i++){
             int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m= matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=i; j<m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<m; i++){
            reverse(matrix[i]);
        }
    }

}