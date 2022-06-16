class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> indexMap = new LinkedHashMap<>();
        for(int i = 0; i < nums.length; i++) indexMap.put(nums[i], i);
        for(int[] operation : operations) {
            int index = indexMap.get(operation[0]);
            nums[index] = operation[1];
            indexMap.remove(operation[0]);
            indexMap.put(nums[index], index);
        }
        return nums;
    }
}