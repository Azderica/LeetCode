class Solution {
    public int missingElement(int[] nums, int k) {
        int index = k;

        for(int i = 0; i < nums.length - 1; i++) {
            if(index > nums[i + 1] - nums[i] - 1) {
                index -= (nums[i + 1] - nums[i] - 1);
            } else {
                return nums[i] + index;
            }
        }

        return nums[nums.length - 1] + index;
   
    }
}