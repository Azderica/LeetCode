class Solution {
    // solution 1. simulation
    public int secondsToRemoveOccurrences(String s) {
        int time = 0;
        while(s.indexOf("01") != -1) {
            s = s.replaceAll("01", "10");
            time++;
        }
        return time;
    }
}