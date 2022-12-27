class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[] start = {0, 0, 0, 0}, target = {n - 1, n - 2, 0};
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // (r, c) + dr(dir) + steps
            int r = cur[0], c = cur[1], dr = cur[2], steps = cur[3];

            if(Arrays.equals(Arrays.copyOf(cur, 3), target))
                return steps;
            if(visited.add(r + "," + c + "," + dr)) {
                // change direction
                if(dr == 0) {
                    if (r + 1  < n && grid[r + 1][c] + grid[r + 1][c + 1] == 0)
                        q.addAll(Arrays.asList(new int[]{r + 1, c, 0, steps + 1}, new int[]{r, c, 1, steps + 1}));
                    if (c + 2 < n && grid[r][c + 2] == 0)
                        q.add(new int[]{r, c + 1, 0, steps + 1});
                } else {
                    if (c + 1 < n && grid[r][c + 1] + grid[r + 1][c + 1] == 0)
                        q.addAll(Arrays.asList(new int[]{r, c + 1, 1, steps + 1}, new int[]{r, c, 0, steps + 1}));
                    if (r + 2 < n && grid[r + 2][c] == 0)
                        q.add(new int[]{r + 1, c, 1, steps + 1});
                }
            }
        }
        return -1;  // fail
    }
}