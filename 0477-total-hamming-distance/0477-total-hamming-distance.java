class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            ans += sum * (nums.length - sum);
        }
        return ans;
    }
}