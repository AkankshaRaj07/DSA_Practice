class Solution {
    public String simplifyPath(String path) {
        int count = 0;
        String[] parts = path.split("/+");
        Stack<String> st = new Stack<>();
        for (String c : parts) {
            if (c.equals(".") || c.equals("")) {
                continue;
            } else if (c.equals("..")) {
                if (!st.isEmpty())
                    st.pop();
            } else {
                st.push(c);
            }
        }
        return "/" + String.join("/", st);
    }
}