class Solution {
    public int minimumRecolors(String blocks, int k) {
        int result = Integer.MAX_VALUE;
        char[] block = blocks.toCharArray();

        for(int i = 0; i <= block.length - k; i++) {
            int white = 0;
            for(int j = i; j < i + k; j++) {
                if(block[j] == 'W') white++;
            }
            result = Math.min(white, result);
        }

        return result;
    }
}