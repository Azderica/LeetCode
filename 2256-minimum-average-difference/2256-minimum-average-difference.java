class Solution {
    public int minimumAverageDifference(int[] nums) {
        int result = -1, n = nums.length, minAvgDiff = Integer.MAX_VALUE;
        if (n == 0) return 0;

        long currPrefixSum = 0, totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            currPrefixSum += nums[i];
            long leftPartAverage = currPrefixSum / (i + 1);
            long rightPargeAverage = i != n - 1 ? (totalSum - currPrefixSum) / (n - i - 1) : 0;

            int curDiff = (int)Math.abs(leftPartAverage - rightPargeAverage);

            if(curDiff < minAvgDiff) {
                minAvgDiff = curDiff;
                result = i;
            }
        }

        return result;
    }
}