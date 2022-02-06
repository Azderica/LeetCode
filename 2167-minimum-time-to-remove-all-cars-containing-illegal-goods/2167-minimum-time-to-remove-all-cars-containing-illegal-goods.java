class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        int[][] l = new int[n][2];
        int[][] r = new int[n][2];

        // make left minimum time
        if (s.charAt(0) == '1') {
            l[0][0] = 1;
            l[0][1] = 2;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                l[i][0] = l[i - 1][0];
                l[i][1] = l[i - 1][1];
            } else {
                l[i][0] = i + 1;
                l[i][1] = Math.min(l[i - 1][0], l[i - 1][1]) + 2;
            }
        }

        // make right minimum time
        if (s.charAt(n - 1) == '1') {
            r[n - 1][0] = 1;
            r[n - 1][1] = 2;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                r[i][0] = r[i + 1][0];
                r[i][1] = r[i + 1][1];
            } else {
                r[i][0] = n - i;
                r[i][1] = Math.min(r[i + 1][0], r[i + 1][1]) + 2;
            }
        }

        // make answer
        int result = n;
        for(int i = -1; i < n; i++) {
            int cost = 0;
            if(i != -1) cost += Math.min(l[i][0], l[i][1]);
            if(i != n - 1) cost += Math.min(r[i + 1][0], r[i + 1][1]);
            result = Math.min(result, cost);
        }
        return result;
    }
}