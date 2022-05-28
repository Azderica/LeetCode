class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rocks.length; i++) {
            list.add(capacity[i] - rocks[i]);
        }
        Collections.sort(list);
        int ans = 0, count = 0;
        for(int value : list) {
            count += value;
            if(count > additionalRocks) break;
            ans++;
        }
        return ans;
    }
}