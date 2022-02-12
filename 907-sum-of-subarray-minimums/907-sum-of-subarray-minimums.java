class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, mod = (int) 1e9 + 7, res = 0;
        int[] dp = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                dp[i] = (i + 1) * arr[i];
            } else {
                dp[i] = dp[st.peek()] + (i - st.peek()) * arr[i];
            }
            st.add(i);
            res += dp[i];
            res %= mod;
        }

        return res;
    }
}