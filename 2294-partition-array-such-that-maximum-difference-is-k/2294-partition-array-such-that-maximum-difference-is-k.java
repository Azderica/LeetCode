class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        // max : 현재 시퀀스에서 최댓값, min : 현재 시퀀스에서 최솟값
        int result = 1, min = nums[0], max = nums[0];
        for(int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            if(max - min > k) { // 값 차이가 k 보다 클시, 다음 시퀀스로
                result++;
                max = min = num;
            }
        }
        return result;
    }
}