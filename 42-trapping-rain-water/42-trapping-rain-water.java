class Solution {
    public int trap(int[] height) {
        // initialize
        int n = height.length, answer = 0;
        int[] left = new int[n], right = new int[n];
        
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
            right[n - i - 1] = Math.max(height[n - i - 1], right[n - i]);
        }
        
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(left[i], right[i]);
            if (height[i] < min) {
                answer += min - height[i];
            }
        }
        return answer;
    }
}