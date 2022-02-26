class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch))
                sb.append(ch);
        }
        String palin = sb.toString();
        
        int n = palin.length();
        if(n <= 1) return true;
        for(int i = 0; i < n / 2; i ++) {
            if(palin.charAt(i) != palin.charAt(n - 1 - i))
                return false;
        }
        return true;
    }
}