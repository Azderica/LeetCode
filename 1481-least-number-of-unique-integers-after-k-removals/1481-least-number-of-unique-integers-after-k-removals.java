class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();

        for (int val : arr) {
            if (countMap.containsKey(val)) {
                countMap.put(val, countMap.get(val) + 1);
            } else {
                countMap.put(val, 1);
            }
        }

        int[] counts = countMap.values().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(counts);
        int index = 0, n = counts.length, sum = 0;
        for(; index < n; index++) {
            sum += counts[index];
            if(sum > k) {
                break;
            }
        }
        return counts.length - index;
    }
}