class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for(int[] update : updates) {
            for(int i = update[0]; i <= update[1]; i++) {
                result[i] += update[2];
            }
        }
        return result;
    }
}