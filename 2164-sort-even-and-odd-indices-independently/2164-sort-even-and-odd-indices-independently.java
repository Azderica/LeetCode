class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }

        Collections.sort(even);
        Collections.sort(odd, Collections.reverseOrder());
        
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                result[i] = even.get(i / 2);
            } else {
                result[i] = odd.get(i / 2);
            }
        }
        return result;
    }
}