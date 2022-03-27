class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] result = new long[queries.length];
        int n = (intLength + 1) / 2;

        long start = (long) Math.pow(10, n - 1);
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > start * 9) {
                result[i] = -1;
                continue;
            }

            long left = start + queries[i] - 1;
            long pos = (long) Math.pow(10, intLength / 2);
            long val = left * pos;
            if (intLength == 1) val = left;

            if (intLength % 2 == 1)
                left /= 10;
            pos /= 10;
            while (left > 0) {
                val += left % 10 * pos;
                left /= 10;
                pos /= 10;
            }
            result[i] = val;
        }
        return result;
    }
}