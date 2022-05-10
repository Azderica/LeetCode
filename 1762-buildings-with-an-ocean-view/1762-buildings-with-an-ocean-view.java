class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> buildings = new ArrayList<>();
        int n = heights.length, max = 0;

        for(int i = n - 1; i >= 0; i--) {
            if(heights[i] > max) {
                buildings.add(i);
                max = heights[i];
            }
        }

        Collections.sort(buildings);
        return buildings.stream().mapToInt(Integer::intValue).toArray();
    }
}