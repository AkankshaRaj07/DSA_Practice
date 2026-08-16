class Solution {
    Map<String, Integer> dp = new HashMap<>();

    public int maxLength(List<String> arr) {
        return solve(arr, 0, "");
    }

    private int solve(List<String> arr, int i, String temp) {
        if(i >= arr.size())
            return temp.length();

        String key = i + "#" + temp;

        if(dp.containsKey(key))
            return dp.get(key);

        int noPick = solve(arr, i + 1, temp);
        int pick = 0;

        if(!hasDuplicate(temp, arr.get(i))) {
            pick = solve(arr, i + 1, temp + arr.get(i));
        }

        dp.put(key, Math.max(pick, noPick));

        return dp.get(key);
    }

    private boolean hasDuplicate(String s1, String s2) {
        int[] freq = new int[26];

        for(char c : s1.toCharArray()) {
            if(freq[c - 'a'] > 0)
                return true;
            freq[c - 'a']++;
        }

        for(char c : s2.toCharArray()) {
            if(freq[c - 'a'] > 0)
                return true;
            freq[c - 'a']++;
        }

        return false;
    }
}