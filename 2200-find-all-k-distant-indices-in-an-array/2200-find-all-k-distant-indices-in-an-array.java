class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] == key) {
                for(int j = Math.max(i - k, 0); j < Math.min(i + k + 1, n); j++) {
                    set.add(j);
                }
            }
        }
        
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}