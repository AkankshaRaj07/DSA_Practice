class Solution {
    public int minimumPairRemoval(int[] nums) {
        int op = 0;
        int n=nums.length;
        while(!isSorted(nums,n)){
            op+=1;
            int minSum=Integer.MAX_VALUE;
            int pos=-1;
            for(int i = 1 ;i<n; i++){
                int sum=nums[i-1]+nums[i];
                if(sum<minSum){
                    minSum=sum;
                    pos=i;
                }
            }
            nums[pos-1]=minSum;
            for(int i= pos; i<n-1; i++) nums[i] =nums[i+1];
            n--;
        }
        return op;
    }
    public boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
}