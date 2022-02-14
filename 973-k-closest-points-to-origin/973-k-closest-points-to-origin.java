class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(x -> {
            return x[0] * x[0] + x[1] * x[1];
        }));

        for(int[] point : points) {
            pq.add(point);
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] tmp = pq.poll();
            res[i][0] = tmp[0];
            res[i][1] = tmp[1];
        }
        return res;
    }
}