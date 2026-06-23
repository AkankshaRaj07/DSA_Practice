import java.util.*;
import java.util.function.BiFunction;

class Solution {
    public int evalRPN(String[] tokens) {

        Map<String, BiFunction<Integer, Integer, Integer>> ops = new HashMap<>();

        ops.put("+", (a, b) -> a + b);
        ops.put("-", (a, b) -> a - b);
        ops.put("*", (a, b) -> a * b);
        ops.put("/", (a, b) -> a / b);

        Stack<Integer> st = new Stack<>();

        for (String s : tokens) {
            if (ops.containsKey(s)) {
                int b = st.pop();
                int a = st.pop();

                st.push(ops.get(s).apply(a, b));
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.peek();
    }
}