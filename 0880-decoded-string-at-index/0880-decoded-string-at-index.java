class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) size *= ch - '0';
            else size++;
        }
        
        for(int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            k %= size;
            if(k == 0 && Character.isLetter(ch)) return ch + "";
            if(Character.isDigit(ch)) size /= ch - '0';
            else size--;
        }

        return "";
    }
}