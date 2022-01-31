class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        long[] p = new long[n + 1];
        long[] h = new long[n + 1];
        long m = modulo;
        
        p[0] = 1;
        for(int i = 1; i <= n; i++) {
            p[i] = (p[i - 1] * power) % m;
        }
        for(int i = n - 1; i >= 0; i--) {
            h[i] = (h[i + 1] * power + getCharValue(s.charAt(i))) % m;
        }
        for(int i = 0; i + k - 1 < n; i++) {
            long curH = (h[i] - h[i + k] * p[k]) % m;
            long tmp = (curH + m) % m;
            if(tmp == hashValue) {
                return s.substring(i, i + k);
            }
        }
        return "";
    }
    
    private long getCharValue(char ch) {
        return ch - 'a' + 1;
    }
    
}