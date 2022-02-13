class Solution {
    public int uniqueLetterString(String s) {
        int res = 0, n = s.length();
        int[] startRange = new int[n];
        int[] endRange = new int[n];
        
        int[] prevCharPos = new int[26];
        Arrays.fill(prevCharPos, -1);
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            startRange[i] = prevCharPos[ch - 'A'] + 1;
            prevCharPos[ch - 'A'] = i;
        }
        
        int[] nextCharPos = new int[26];
        Arrays.fill(nextCharPos, n);
        for(int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            endRange[i] = nextCharPos[ch - 'A'] - 1;
            nextCharPos[ch - 'A'] = i;
        }
        
        for(int i = 0; i < n; i++) {
            res += (i - startRange[i] + 1) * (endRange[i] - i + 1);
        }
        return res;
    }
}