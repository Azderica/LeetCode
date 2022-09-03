class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length, ans = 0;
        long maxScore = 0;
        long[] score = new long[n];
        for(int i = 0; i < n; i++) {
            score[edges[i]] += i;
        }
        for(int i = 0; i < n; i++) {
            if(maxScore < score[i]) {
                maxScore = score[i];
                ans = i;
            }
        }

        return ans;
    }
}