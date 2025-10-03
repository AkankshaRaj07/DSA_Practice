class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        String curr= "";
        return rec(list,n, 0, 0,curr);
    }
    public List<String> rec(List <String> list, int n, int open, int close,String curr){
        if(curr.length()== 2*n) list.add(curr);
        if(open < n){
            rec(list,n,open+1,close, curr+ '(');
        }
        if(close<open){
            rec(list,n,open,close+1, curr + ')');
        }
        return list;
    }
}