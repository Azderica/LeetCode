class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        
        int m = grid.length, n = grid[0].length, fresh = 0, rotten = 0, date = -1;
        boolean[][] visited = new boolean[m][n];
        Queue<Pos> nextQueue, queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pos(i, j));
                    visited[i][j] = true;
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        // all orange are rotten.
        if(fresh == 0)
            return 0;
        
        while(!queue.isEmpty()) {
            nextQueue = new LinkedList<>();
            date++;
            
            while(!queue.isEmpty()) {
                Pos cur = queue.poll();
                for(int dir = 0; dir < 4; dir++) {
                    int nextY = cur.y + dy[dir];
                    int nextX = cur.x + dx[dir];
                    if(isInBoard(m, n, nextY, nextX) && !visited[nextY][nextX] && grid[nextY][nextX] == 1) {
                        nextQueue.add(new Pos(nextY, nextX));
                        visited[nextY][nextX] = true;
                        rotten++;   
                    }
                }
            }
            
            queue.addAll(nextQueue);
        }
        
        if(fresh == rotten) {
            return date;
        } else {
            return -1;
        }
    }
    
    private boolean isInBoard(int m, int n, int y, int x) {
        return y >= 0 && y < m && x >= 0 && x < n;
    }
    
    class Pos {
        int y, x;
        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}