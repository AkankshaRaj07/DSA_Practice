class Solution {
    public int sumSubarrayMins(int[] arr) {
        long mod = 1000000007L;
        int n = arr.length; 
        int [] nsl = getNsl(arr,n);
        int [] nsr = getNsr(arr,n);
        long sum = 0;
        for(int i = 0; i<n; i++){
            int l = i - nsl[i];
            int r = nsr[i] - i;
            sum = (sum + (long) l * r * arr[i]) % mod;
        }
        return (int) sum;
    }
    public int[] getNsl(int[] arr, int n){
        Stack <Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i =0; i<n; i++){
            if(st.isEmpty()) result[i] = -1;
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]){
                st.pop();
                
            }
            result[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return result;
    }
    public int[] getNsr(int[] arr, int n){
        Stack <Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i = n-1; i>=0; i--){
            if(st.isEmpty()) result[i] = n-1;
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
                
            }
            result[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return result;
    }
}