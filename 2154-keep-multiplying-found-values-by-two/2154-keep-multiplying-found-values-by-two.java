class Solution {
    public int findFinalValue(int[] nums, int original) {
        int result = original;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        while(original <= 1000 && list.contains(result)) {
            result *= 2;
        }
        
        return result;
    }
}