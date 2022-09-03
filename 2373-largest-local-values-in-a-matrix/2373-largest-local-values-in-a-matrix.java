class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] answer = new int[n - 2][n - 2];
        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < n - 2; j++) {
                answer[i][j] = getMaxNum(grid, i, j);
            }
        }
        return answer;
    }

    private int getMaxNum(int[][] grid, int y, int x) {
        int maxNum = 0;
        for(int i = y; i <= y + 2; i++) {
            for(int j = x; j <= x + 2; j++) {
                maxNum = Math.max(maxNum, grid[i][j]);
            }
        }
        return maxNum;
    }
}