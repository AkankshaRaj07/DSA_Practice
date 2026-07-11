class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String>  res = new ArrayList<>();
        backtrack(0,digits, res, "", map);
        return res;
    }
    private void backtrack(int index, String digits, List<String> res,
                           String curr, HashMap<Character, String> map) {

        if (index == digits.length()) {
            res.add(curr);
            return;
        }

        String letters = map.get(digits.charAt(index));

        for (char ch : letters.toCharArray()) {
            backtrack(index + 1, digits, res, curr + ch, map);
        }
    }

}