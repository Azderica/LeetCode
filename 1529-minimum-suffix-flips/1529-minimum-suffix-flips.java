class Solution {
    public int minFlips(String target) {
        int flips = 0;
        char prev = target.charAt(0);

        if(prev == '1') flips++;
        for(int i = 1; i < target.length(); i++) {
            char ch = target.charAt(i);
            if(ch != prev) {
                flips++;
                prev = ch;
            }
        }

        return flips;
    }
}