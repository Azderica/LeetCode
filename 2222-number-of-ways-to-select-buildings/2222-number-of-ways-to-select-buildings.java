class Solution {
    public long numberOfWays(String s) {
        return numberOfWays(s, 3);
    }

    private long numberOfWays(String s, int k) {
        long[][] dp = new long[k + 1][2];
        Arrays.fill(dp[0], 1);
        for(char ch: s.toCharArray()) {
            int num = ch - '0';
            for(int cnt = k; cnt > 0; cnt--) {
                dp[cnt][num] += dp[cnt - 1][1 - num];
            }
        }
        return dp[k][0] + dp[k][1];
    }
}