class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0, points = 0, start = 0, end = tokens.length - 1;
        while (start <= end) {
            if(power >= tokens[start]) {
                power -= tokens[start++];
                res = Math.max(res, ++points);
            } else if(points > 0) {
                points--;
                power += tokens[end--];
            } else {
                break;
            }
        }
        return res;
    }
}