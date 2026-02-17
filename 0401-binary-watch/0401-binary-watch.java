import java.util.*;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {

                int bits = Integer.bitCount(h) + Integer.bitCount(m);

                if (bits == turnedOn) {
                    // minute must be 2 digits
                    String time = h + ":" + String.format("%02d", m);
                    ans.add(time);
                }
            }
        }
        return ans;
    }
}
