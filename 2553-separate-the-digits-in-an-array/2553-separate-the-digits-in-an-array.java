class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: nums){
            String s = String.valueOf(i);
            for (char c : s.toCharArray()) {
                list.add(c - '0');
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}