class Solution {
    public int minSwaps(String s) {
        int open = 0, imbalance = 0;
        for(char c : s.toCharArray()){
            if(c == '[') open++;
            else {
                if(open > 0) open--;
                else imbalance++;
            }
        }
        return (imbalance + 1) / 2;
    }
}