class Solution {
    public boolean splitString(String s) {
        return isDescOrder(s, null);
    }
    
    private boolean isDescOrder(String s, Long prev) {
        long cur = 0;
        for(int i = 0; i < s.length(); i++) {
            cur = cur * 10 + (s.charAt(i) - '0');
            if(cur >= 10000000000L) return false;
            if(prev == null) {
                if(isDescOrder(s.substring(i + 1), cur))
                    return true;
            } else if(cur == prev - 1 && (i == s.length() - 1 || isDescOrder(s.substring(i + 1), cur))) {
                return true;
            }
        }
        return false;
    }
}