class Solution {
    public int rob1(int[] nums) {
        int n= nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int prev2=0;
        int prev1=nums[0];
        int ans=0;
        for(int i=1; i<n;i++){
            int pick=nums[i]+prev2;
            int nopick=prev1;
            ans=Math.max(pick,nopick);
            prev2=prev1;
            prev1=ans;
        }
        return ans;
    }
    public int rob(int [] nums){
        int n=nums.length;
        if(n==1) return nums[0];
        int nums1[]= new int[n-1];
        int nums2[]= new int [n-1];
        for(int i = 1, j = 0; i < n; i++, j++){
            nums1[j] = nums[i];
        }
        for(int i = 0, k = 0; i < n-1; i++, k++){
            nums2[k] = nums[i];
        }
        // int j=0,k=0;
        // for(int i=1; i<n; i++){
        //     if(i!=0){
        //         nums1[j]=nums[i];
        //         j++;
        //     }
        //     if(i!=n-1){
        //         nums2[k]=nums[i];
        //         k++;
        //     }
        // }
        return Math.max(rob1(nums1),rob1(nums2));
    }
}