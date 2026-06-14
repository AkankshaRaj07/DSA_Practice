class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0;
        int total = 0;
        for(int x : cardPoints) {
            total += x;
        }
        if(k == cardPoints.length) return total;
        for(int right = 0; right < cardPoints.length; right++){
            currSum += cardPoints[right];
            if(right-left+1 == cardPoints.length -k){
                sum = Math.min(currSum,sum);
                currSum -= cardPoints[left];
                left++;
            }
            
        }
        return total-sum;
    }
}