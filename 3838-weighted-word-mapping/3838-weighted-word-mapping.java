class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for (String w : words) {
            int sum = 0;
            for (char c : w.toCharArray()) sum += weights[c - 'a'];
            int mod = ((sum % 26) + 26) % 26;
            ans.append((char)('z' - mod));
        }
        return ans.toString();
    }
}
