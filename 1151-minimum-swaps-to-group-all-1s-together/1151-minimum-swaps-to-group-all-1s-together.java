class Solution {
    public int minSwaps(int[] data) {
        int sum = Arrays.stream(data).sum();
        int cnt_one = 0, max_one = 0;
        int left = 0, right = 0;
        
        while(right < data.length) {
            cnt_one += data[right++];
            if(right - left > sum) {
                cnt_one -= data[left++];
            }
            max_one = Math.max(max_one, cnt_one);
        }
        
        return sum - max_one;
    }
}