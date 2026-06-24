class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i : asteroids) {
            while (!st.isEmpty() && i < 0 && st.peek() > 0) {
                int sum = st.peek() + i;
                if (sum > 0) i = 0;
                else if (sum < 0) st.pop();
                else {
                    st.pop();
                    i = 0;
                }
            }
            if (i != 0) st.push(i);
        }
        int[] result = new int[st.size()];
        int n = st.size();
        while(!st.isEmpty()){
            result[n-1] = (st.pop());
            n--;
        }
        return result;
    }
    
}

