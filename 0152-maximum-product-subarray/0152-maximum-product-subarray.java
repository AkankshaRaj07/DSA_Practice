class Solution {
    public int maxProduct(int[] nums) {
         int maxProd = nums[0];

        // Outer loop picks the starting index
        for (int i = 0; i < nums.length; i++) {
            // Initialize current product to 1
            int prod = 1;

            // Inner loop picks the ending index
            for (int j = i; j < nums.length; j++) {
                // Multiply current number to product
                prod *= nums[j];

                // Update maximum product if needed
                maxProd = Math.max(maxProd, prod);
            }
        }

        // Return the result
        return maxProd;
    
    }
}