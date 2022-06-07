class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length, result = 0, j = -1;
        int[] dp = new int[n], stack = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            while (j >= 0 && nums[i] > nums[stack[j]]) {
                dp[i] = Math.max(++dp[i], dp[stack[j--]]);
                result = Math.max(result, dp[i]);
            }
            stack[++j] = i;
        }

        return result;
    }
}