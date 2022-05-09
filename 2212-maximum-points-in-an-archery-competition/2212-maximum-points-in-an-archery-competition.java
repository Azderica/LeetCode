class Solution {
    int[] bobArrows = new int[12];
    int maxScore = 0;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        maxScore(numArrows, aliceArrows, new int[12], 11, 0);
        return bobArrows;
    }

    private void maxScore(int arrows, int[] aliceArrows, int[] curArrows, int index, int curScore) {
        if(arrows == 0 || index < 0) {
            if(curScore > maxScore) {
                if(arrows > 0) {
                    curArrows[0] += arrows;
                }
                bobArrows = curArrows;
                maxScore = curScore;
            }
            return;
        }

        // get score in this index
        int[] nextArrows = curArrows.clone();
        int alicePoints = aliceArrows[index];
        if(arrows > alicePoints) {
            nextArrows[index] = alicePoints + 1;
            maxScore(arrows - alicePoints - 1, aliceArrows, nextArrows, index - 1, curScore + index);
        }
        // get no score in this index
        maxScore(arrows, aliceArrows, curArrows, index - 1, curScore);
    }
}