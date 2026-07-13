class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String s = "123456789";
        int min = String.valueOf(low).length();
        int max = String.valueOf(high).length();
        for(int i = min; i<=max; i++){
            for(int j = 0; i+j<=s.length(); j++ ){
                int nums = Integer.parseInt(s.substring(j,j+i));
                if(nums>=low && nums<=high) ans.add(nums);
            }
        }
        return ans;
    }
}