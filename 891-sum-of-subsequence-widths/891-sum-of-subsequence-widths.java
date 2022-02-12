class Solution {
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        long sum = 0, mod = (long)1e9 + 7, d = 1;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++) {
            long upper = (nums[i] * d);
            long lower = (nums[n - i - 1] * d);
            sum = (sum + upper - lower) % mod;
            d = d * 2 % mod;
        }
        
        return (int)((sum + mod) % mod);
    }
}