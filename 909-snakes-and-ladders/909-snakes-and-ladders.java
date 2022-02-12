class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(1);
       
        int level = 0;
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            for(int i = 0; i < size; i++) {
                int node = nodes.poll();
                if(visited[node]) continue;
                visited[node] = true;
                if(node == n * n) return level;
                for(int next = 1; next <= 6 && node + next <= n * n; next++) {
                    int nextNode = node + next;
                    int boardValue = getBoardValue(board, n, nextNode);
                    if(boardValue != -1) nextNode = boardValue;
                    if(!visited[nextNode]) nodes.add(nextNode);
                }
            }
            
            level++;
        }
        
        return -1;
    }
    
    private int getBoardValue(int[][] board, int n, int i) {
        int row = (i - 1) / n;
        int col = (i - 1) % n;
        if(row % 2 == 1) col = n - col - 1;
        return board[n - row - 1][col];
    }
}