class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size() + 1][k + 1];
        return maxValueOfCoins(piles, dp, 0, k);
    }

    private int maxValueOfCoins(List<List<Integer>> piles, int[][] dp, int index, int k) {
        if(k == 0 || index == piles.size())
            return 0;
        if(dp[index][k] != 0)
            return dp[index][k];
        int result = maxValueOfCoins(piles, dp, index + 1, k);
        int cur = 0;
        for(int i = 0; i < Math.min(piles.get(index).size(), k); i++) {
            cur += piles.get(index).get(i);
            result = Math.max(result, cur + maxValueOfCoins(piles, dp, index + 1, k - i - 1));
        }
        return dp[index][k] = result;
    }
}