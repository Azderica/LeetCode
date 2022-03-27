class Solution {
    public int minDeletion(int[] nums) {
        int result = 0, n = nums.length;

        for (int i = 0, j = 1; j < n; ) {
            while (j < n && nums[i] == nums[j]) {
                result++;
                j++;
            }

            i = j + 1;
            j = i + 1;
        }

        if((n - result) % 2 == 1)
            result++;

        return result;
    }
}