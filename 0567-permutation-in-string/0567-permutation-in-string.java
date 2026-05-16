class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];

        // frequency of s1
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = s1.length();

        while (right < s2.length()) {

            // if character is needed
            if (freq[s2.charAt(right) - 'a'] > 0) {
                count--;
            }

            freq[s2.charAt(right) - 'a']--;
            right++;

            // found permutation
            if (count == 0) {
                return true;
            }

            // maintain window size
            if (right - left == s1.length()) {

                if (freq[s2.charAt(left) - 'a'] >= 0) {
                    count++;
                }

                freq[s2.charAt(left) - 'a']++;
                left++;
            }
        }

        return false;
    }
}