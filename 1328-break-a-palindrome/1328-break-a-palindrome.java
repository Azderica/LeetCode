class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if(len == 1) return "";

        char[] palindromeArray = palindrome.toCharArray();
        for(int i = 0; i < len / 2; i++) {
            if(palindromeArray[i] != 'a') {
                palindromeArray[i] = 'a';
                return String.valueOf(palindromeArray);
            }
        }

        palindromeArray[len - 1] = 'b';
        return String.valueOf(palindromeArray);
    }
}