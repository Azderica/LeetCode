class Solution {
    public int triangularSum(int[] nums) {
        int len = nums.length;

        for(int i = 1; i < len; i++) {
            for(int j = 0; j < len - i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }

        return nums[0];
    }
}