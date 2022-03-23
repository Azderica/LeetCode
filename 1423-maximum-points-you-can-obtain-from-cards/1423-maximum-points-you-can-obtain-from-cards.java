class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(k >= n) {
            return Arrays.stream(cardPoints).sum();
        }

        int score = 0, cur = 0;
        for(int i = 0; i < k; i++) {
            cur += cardPoints[i];       // start in left
        }
        score = cur;
        for(int i = 0; i < k; i++) {
            cur -= cardPoints[k - i - 1];
            cur += cardPoints[n - i - 1];
            score = Math.max(score, cur);
        }

        return score;
    }
}