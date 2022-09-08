class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[1001][1001];
        int mod = 1_000_000_007;

        if (dp[1][1] == 0) {
            for (int j = 1; j <= 1000; j++) {
                dp[j][j] = 1;
                for (int i = 0; i < j; i++) {
                    dp[j][i] = (dp[j - 1][Math.abs(i - 1)] + dp[j - 1][i + 1]) % mod;
                }
            }
        }
        return dp[k][Math.abs(startPos - endPos)];
    }
}