class Solution {

    static class Pair {
        int freq;
        char ch;

        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public String frequencySort(String s) {

        Pair[] freq = new Pair[128]; // support ASCII chars
        for (int i = 0; i < 128; i++) {
            freq[i] = new Pair(0, (char) i);
        }

        // count frequency
        for (char ch : s.toCharArray()) {
            freq[ch].freq++;
        }

        // sort by frequency desc, character asc (if needed)
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq)
                return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });

        StringBuilder sb = new StringBuilder();

        for (Pair p : freq) {
            if (p.freq > 0) {
                sb.append(String.valueOf(p.ch).repeat(p.freq));
            }
        }

        return sb.toString();
    }
}
