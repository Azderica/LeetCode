class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int leftSum = 0, rightSum = Arrays.stream(nums).sum();
        int n = nums.length, maxNum = rightSum;
        int[] score = new int[n + 1];

        score[0] = rightSum;
        for(int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            maxNum = Math.max(maxNum, i + 1 - leftSum + rightSum);
            score[i + 1] = i + 1 - leftSum + rightSum;
        }

        for(int i = 0; i <= n; i++) {
            if(score[i] == maxNum) {
                result.add(i);
            }
        }
        return result;
    }
}