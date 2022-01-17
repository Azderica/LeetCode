class Solution {
    public long maxRunTime(int n, int[] batteries) {
        // initialize
        long left = 1, right = (long)(1e16/n), mid, answer = left;

        // main logic, binary search
        while(left <= right) {
            mid = (left + right) >> 1;
            if(isPossible(batteries, n, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // return answer;
        return answer;
    }
    
    private boolean isPossible(int[] batteries, int n, long mid) {
        long total = n * mid;
        long sum = 0;
        for(int battery : batteries) {
            // 1 battery can run a minimum of (mid, its life time)
            sum += Math.min(battery, mid);
        }
        return sum >= total;
    }
}