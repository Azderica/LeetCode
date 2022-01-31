class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length, one = 0;
        for(int i = 0; i < n; i++) one += nums[i];
        int max = one;
        
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0)
                one += 1;
            else
                one -= 1;
            if(one == max) {
                result.add(i + 1);
            } else if (one > max) {
                max = one;
                result = new ArrayList<>();
                result.add(i + 1);
            }
        }
            
        return result;
    }
}