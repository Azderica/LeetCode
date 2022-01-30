class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n * k == 0) return new int[0];
        if(k == 1) return nums;

        int[] result = new int[n - k + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++) {
            // left -> right
            if(i % k == 0) left[i] = nums[i];
            else left[i] = Math.max(left[i - 1], nums[i]);
            
            int j = n - i - 1;
            if((j + 1) % k == 0) right[j] = nums[j];
            else right[j] = Math.max(right[j + 1], nums[j]);
        }
        
        for(int i = 0; i < n - k + 1; i++)
            result[i] = Math.max(left[i + k - 1], right[i]);
        
        return result;
    }
}