class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int min, max, n = nums.length;
        
        for(int i = 0; i < n - 1; i++) {
            min = max = nums[i];
            for(int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (max - min);
            }
        }
        
        return sum;
    }
}