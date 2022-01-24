class Solution {
    public int maxProfit(int[] inventory, int orders) {
        if (inventory.length == 0) return 0;
        
        long mod = (int) 1e9 + 7;
        long max = (int) 1e9, min = 0;
        while(max > min) {
            long mid = (max + min) / 2;
            long sum = 0;
            for(int ball : inventory) {
                if(ball > mid) {
                    sum += ball - mid;
                }
            }
            if(sum > orders) min = mid + 1;
            else max = mid;
        }
        long sum = 0;
        for(int ball : inventory) {
            if(ball > min) {
                sum += (long)(ball + min + 1) * (ball - min) / 2;
                orders -= (ball - min);
            }
        }
        sum += orders * min;
        return (int) (sum % mod);
    }
}