class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = Integer.MAX_VALUE;
        int n = tops.length;

        // exception case
        if(tops.length != bottoms.length)
            return -1;

        for(int val = 1; val <= 6; val++) {
            boolean isFail = false;
            int top_moves = 0, bottom_moves = 0;
            for(int i = 0; i < n; i++) {
                if(tops[i] == val && bottoms[i] != val) {
                    bottom_moves++;
                } else if(bottoms[i] == val && tops[i] != val) {
                    top_moves++;
                } else if(tops[i] == val && bottoms[i] == val) {
                    // no move
                } else {
                    isFail = true;
                    break;
                }
            }

            if(isFail) continue;

            result = Math.min(top_moves, bottom_moves);
        }

        if(result == Integer.MAX_VALUE)
            return -1;
        return result;
    }
}