class Solution {
    public String largestPalindromic(String num) {
        int[] numeric = new int[10];
        for(char ch : num.toCharArray()) {
            numeric[ch - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        int single = - 1;
        for(int i = 9; i >= 0; i--) {
            if(sb.length() == 0 && i == 0) continue;;
            while(numeric[i] > 1) {
                sb.append((char)('0' + i));
                numeric[i] -= 2;
            }
            if(numeric[i] == 1 && single == -1) single = i;
        }
        if(sb.length() == 0 && single == -1) return "0";
        int index = sb.length() - 1;
        if(single != -1) sb.append((char)(single + '0'));
        for(; index >= 0; index--) {
            sb.append(sb.charAt(index));
        }
        return sb.toString();
    }
}