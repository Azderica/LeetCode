class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] alphabet = new int[26];
        char[] arrays = new char[n];

        // exception case
        if(n <= 1) return s;
        if(n == 2) return (s.charAt(0) == s.charAt(1)) ? "" : s;

        // check invalid case
        for(int i = 0; i < n; i++) {
            if(++alphabet[(s.charAt(i) - 'a')] > (n + 1) / 2) return "";
        }

        // make reorganize string
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < 26; i++) {
            if(alphabet[i] > 0)
                pq.add(new int[]{i, alphabet[i]});
        }
        for(int i = 0; i < n - 1; i += 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            arrays[i] = (char)('a' + first[0]);
            arrays[i + 1] = (char)('a' + second[0]);

            if(first[1] > 1) {
                first[1]--;
                pq.add(first);
            }
            if(second[1] > 1) {
                second[1]--;
                pq.add(second);
            }
        }
        if(!pq.isEmpty()) {
            int[] last = pq.poll();
            arrays[n - 1] = (char)('a' + last[0]);
        }
        return String.valueOf(arrays);
    }
}