class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int right = n - 1, left = 0;
        int[] diff = new int[n];
        long cnt = 0;

        for(int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(diff);
        while(left < right) {
            int sum = diff[left] + diff[right];
            if(sum > 0) {
                cnt += right - left;
                right--;
            } else {
                left++;
            }
        }
        return cnt;
    }
}