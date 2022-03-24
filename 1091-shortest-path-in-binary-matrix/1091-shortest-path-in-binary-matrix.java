class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        if (grid[0][0] == 0) {
            queue.add(new int[]{0, 0, 1});
            visited[0][0] = true;
        }
        while (!queue.isEmpty()) {
            int curY = queue.peek()[0];
            int curX = queue.peek()[1];
            int depth = queue.poll()[2];

            if (curY == n - 1 && curX == n - 1)
                return depth;

            for (int d = 0; d < 8; d++) {
                int nextY = curY + dy[d];
                int nextX = curX + dx[d];
                if (isInBoard(nextY, nextX, n) && grid[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    queue.add(new int[]{nextY, nextX, depth + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
        return -1;
    }

    private boolean isInBoard(int y, int x, int n) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}