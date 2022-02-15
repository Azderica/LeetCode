class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int res = 0;
        
        for(int t : time) {
            if(t % 60 == 0) {
                res += remainders[0];
            } else {
                res += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        
        return res;
    }
}