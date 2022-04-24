class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<Integer> points = new HashSet<>();

        for(int[] circle: circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];

            for(int i = y - r; i <= y + r; i++) {
                for(int j = x - r; j <= x + r; j++) {
                    if(isInCircle(i, j, y, x, r)) {
                        points.add(i * 1000 + j);
                    }
                }
            }
        }

        return points.size();
    }

    private boolean isInCircle(int y, int x, int cy, int cx, int r) {
        return Math.sqrt(Math.pow(y - cy, 2) + Math.pow(x - cx, 2)) <= r;
    }
}