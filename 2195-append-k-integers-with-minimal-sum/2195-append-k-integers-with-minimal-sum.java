class Solution {
    public long minimalKSum(int[] nums, int k) {
        long sum = 1L * k * (k + 1) / 2;
        int count = 0;
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for(int num : numSet) {
            if(num <= k) {
                sum -= num;
                count++;
            }
        }

        int cur = k + 1;
        while (count > 0) {
            if(!numSet.contains(cur)) {
                sum += cur;
                count--;
            }
            cur++;
        }

        return sum;
    }
}