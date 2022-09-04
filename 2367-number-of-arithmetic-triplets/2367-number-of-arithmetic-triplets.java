class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int answer = 0;
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for(int num : nums) {
            if(numSet.contains(num) && numSet.contains(num + diff) && numSet.contains(num + diff * 2))
                answer++;
        }
        return answer;
        
    }
}