class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length(), sum = 0, result = 0;
        int[] count = new int[n];
        for(int i = 0; i < n; i++) {
            if("aeiou".indexOf(s.charAt(i)) >= 0) {
                count[i] = 1;
            }
        }

        for(int i = 0; i < k; i++) {
            sum += count[i];
        }
        result = sum;
        for(int i = 0; i < n - k; i++) {
            if(result == k)
                break;
            sum += count[i + k];
            sum -= count[i];
            result = Math.max(result, sum);
        }
        return result;
    }
}