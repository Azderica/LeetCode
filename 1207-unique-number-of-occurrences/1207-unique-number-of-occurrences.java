class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int MAX = 1000;
        int freq[] = new int[2 * MAX + 1];

        for(int num : arr) {
            freq[num + MAX]++;
        }
        Arrays.sort(freq);

        for(int i = 0; i < 2 * MAX; i++) {
            if(freq[i] != 0 && freq[i] == freq[i + 1]) {
                return false;
            }
        }
        return true;
    }
}