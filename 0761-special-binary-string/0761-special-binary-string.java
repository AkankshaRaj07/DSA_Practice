class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;

        // split into primitive special substrings
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1') count++;
            else count--;

            // found one balanced block
            if(count == 0){
                // recursive processing of inner substring
                String inner = s.substring(start + 1, i);
                String processed = "1" + makeLargestSpecial(inner) + "0";
                list.add(processed);
                start = i + 1;
            }
        }

        // sort descending to get lexicographically largest
        Collections.sort(list, Collections.reverseOrder());

        // build result
        StringBuilder res = new StringBuilder();
        for(String str : list){
            res.append(str);
        }

        return res.toString();
    }
}