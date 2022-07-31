public class Solution {
    public int fillCups(int[] amount) {
        int seconds = 0, first = amount.length - 1, second = amount.length - 2;
        Arrays.sort(amount);

        while(amount[first] > 0 && amount[second] > 0) {
            amount[first]--;
            amount[second]--;
            seconds++;
            Arrays.sort(amount);
        }

        while(amount[first] > 0) {
            amount[first]--;
            seconds++;
        }
        return seconds;
    }
}
