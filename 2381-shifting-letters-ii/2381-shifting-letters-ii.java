class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] count = new int[s.length() + 1];
        char[] ch = s.toCharArray();

        for (int[] shift: shifts) {
            if(shift[2] == 1) {
                count[shift[0]] += 1;
                count[shift[1] + 1] -= 1;
            } else {
                count[shift[0]] -= 1;
                count[shift[1] + 1] += 1;
            }
        }

        int sum = 0;
        for(int i = 0; i < count.length - 1; i++) {
            sum += count[i];
            int newChar = ((ch[i] - 'a') + sum) % 26;
            if(newChar < 0) newChar += 26;
            ch[i] = (char)('a' + newChar);
        }
        return new String(ch);
    }
}