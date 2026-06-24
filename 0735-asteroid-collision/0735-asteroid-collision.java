class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i : asteroids) {
            while (!st.isEmpty() && i < 0 && st.peek() > 0) {
                int sum = st.peek() + i;
                if (sum > 0)
                    i = 0;
                else if (sum < 0)
                    st.pop();
                else {
                    st.pop();
                    i = 0;
                }
            }
            if (i != 0)
                st.push(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
    while(!st.isEmpty())ans.add(st.pop());
    int[] result = new int[ans.size()];
    Collections.reverse(ans);
    for(int i = 0;i<ans.size();i++) result[i] = ans.get(i);
    return result;
    }
    
}

