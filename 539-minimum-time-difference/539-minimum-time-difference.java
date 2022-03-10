class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> timeValues = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for(String timePoint : timePoints) {
            timeValues.add(getTimeValue(timePoint));
        }

        Collections.sort(timeValues);
        timeValues.add(timeValues.get(0) + 24 * 60);

        for(int i = 0; i < timeValues.size() - 1; i++) {
            int cur = timeValues.get(i + 1) - timeValues.get(i);
            if(cur < minDiff)
                minDiff = cur;
        }

        return minDiff;
    }

    private Integer getTimeValue(String s) {
        return Integer.valueOf(s.split(":")[0]) * 60 + Integer.valueOf(s.split(":")[1]);
    }
}