class Solution {
    public int minOperations(String s) {
        int changes1 = 0;
        int changes2 = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(i % 2 == 0) {
                if(c != '0') changes1++;
                if(c != '1') changes2++;
            } 
            else {
                if(c != '1') changes1++;
                if(c != '0') changes2++;
            }
        }

        return Math.min(changes1, changes2);
    }
}