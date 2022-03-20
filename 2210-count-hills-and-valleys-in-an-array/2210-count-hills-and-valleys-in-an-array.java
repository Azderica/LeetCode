class Solution {
    public int countHillValley(int[] nums) {
        int result = 0, n = nums.length;

        // exception case
        if(n <= 2)
            return 0;

        int state = 0;  // 0 : -, 1 : /, 2 : \
        for(int i = 0; i < n - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                if(state == 1) result++;
                state = 2;
            }
            if(nums[i] < nums[i + 1]) {
                if(state == 2) result++;
                state = 1;
            }
        }

        return result;
    }
}