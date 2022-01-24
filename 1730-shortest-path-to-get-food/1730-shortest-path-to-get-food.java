class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length, result = -1;
        
        result = getShortestPathLength(grid, m, n);
        
        return result;
    }
    
    private int getShortestPathLength(char[][] grid, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        Queue<Pos> q = new LinkedList<>();
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '*') {
                    q.add(new Pos(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            
            if(grid[cur.y][cur.x] == '#')
                return cur.depth;
            
            for(int dir = 0; dir < 4; dir++) {
                int nextY = cur.y + dy[dir];
                int nextX = cur.x + dx[dir];
                if(isValid(grid, nextY, nextX, m, n) && !visited[nextY][nextX]) {
                    q.add(new Pos(nextY, nextX, cur.depth + 1));
                    visited[nextY][nextX] = true;
                }
            } 
        }
        
        return -1;
    }
    
    private boolean isValid(char[][] grid, int y, int x, int m, int n) {
        if(y < 0 || y >= m || x < 0 || x >= n)
            return false;
        if(grid[y][x] == 'X')
            return false;
        return true;
    }
    
    
    class Pos {
        int y, x, depth;
        Pos(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}