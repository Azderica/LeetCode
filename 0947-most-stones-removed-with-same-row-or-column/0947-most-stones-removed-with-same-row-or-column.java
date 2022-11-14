class Solution {
    private final int K = 10001;

    private void dfs(int[][] stones, List<Integer>[] graph, boolean[] visited, int src) {
        visited[src] = true;
        for(int vertex : graph[src]) {
            if(!visited[vertex]) {
                dfs(stones, graph, visited, vertex);
            }
        }
    }

    public int removeStones(int[][] stones) {
        List<Integer>[] graph = new ArrayList[2 * K + 1];

        for(int i = 0; i < 2 * K + 1; i++) { graph[i] = new ArrayList<>(); }
        for(int i = 0; i < stones.length; i++) {
            int x = stones[i][0];
            int y = stones[i][1] + K;
            graph[x].add(y);
            graph[y].add(x);
        }

        boolean[] visited = new boolean[2 * K + 1];
        int componentCount = 0;
        for(int i = 0; i < 2 * K + 1; i++) {
            if(!visited[i] && graph[i].size() > 0) {
                componentCount++;
                dfs(stones, graph, visited, i);
            }
        }

        return stones.length - componentCount;
    }
}