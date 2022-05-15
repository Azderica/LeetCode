class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);

        int maxValue = 0;
        maxValue = Math.max(maxValue, special[0] - bottom);
        for(int i = 1; i < special.length; i++) {
            maxValue = Math.max(maxValue, special[i] - special[i - 1] - 1);
        }
        maxValue = Math.max(maxValue, top - special[special.length - 1]);
        return maxValue;
        
    }
}