class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = Arrays.stream(nums[0]).boxed().collect(Collectors.toList());
        for(int i = 1; i < nums.length; i++) {
            List<Integer> line = Arrays.stream(nums[i]).boxed().collect(Collectors.toList());
            result = result.stream()
                    .distinct()
                    .filter(line::contains)
                    .collect(Collectors.toList());
        }
        Collections.sort(result);
        return result;
    }
}