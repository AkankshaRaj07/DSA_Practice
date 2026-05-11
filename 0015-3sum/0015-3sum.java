class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int target = -(arr[i] + arr[j]);
                if (set.contains(target)) {
                    List<Integer> temp = Arrays.asList(arr[i], target, arr[j]);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                set.add(arr[j]);
            }
        }
        return new ArrayList<>(ans);
    }
}