class Solution {
    // z-algorithm : https://sgc109.tistory.com/208
    public long sumScores(String s) {
        int n = s.length(), l = 0, r = 0;
        char[] ss = s.toCharArray();
        int[] z = new int[n];

        for(int i = 1; i < n; i++) {
            if(i <= r) {
                // 현재 위치는 공통 prefix 위치입니다.
                // 계산된 z 값을 통해 z[i] 값을 초기화 합니다.
                z[i] = Math.min(z[i - l], r - i + 1);
            }
            while (i + z[i] < n && ss[z[i]] == ss[i + z[i]]) {
                z[i]++;
            }
            if(i + z[i] - 1 > r) {
                // 현재 위치는 공통 prefix 외의 영역입니다.
                // 이를 trivial algorithm 을 사용해서 처리합니다.
                l = i;
                r = i + z[i] - 1;
            }
        }
        long sum = n;
        for(int val: z) sum += val;
        return sum;
    }
}