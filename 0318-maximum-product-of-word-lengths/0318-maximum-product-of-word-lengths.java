class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        int bitmask = 0, bitNum = 0;
        for(String word : words) {
            bitmask = 0;
            for(char ch : word.toCharArray()) {
                bitmask |= 1 << bitNumber(ch);
            }
            hashMap.put(bitmask, Math.max(hashMap.getOrDefault(bitmask, 0), word.length()));
        }

        int result = 0;
        for(int x : hashMap.keySet()) {
            for(int y : hashMap.keySet()) {
                if((x & y) == 0) result = Math.max(result, hashMap.get(x) * hashMap.get(y));
            }
        }
        return result;
    }

    private int bitNumber(char ch) {
        return (int)ch - (int)'a';
    }
}