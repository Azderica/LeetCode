class Solution {
    public int convertTime(String current, String correct) {
        int answer = 0;
        int timeGap = getTime(correct) - getTime(current);
        if(timeGap < 0) {
            timeGap += 60 * 24;
        }

        answer += timeGap / 60;
        timeGap %= 60;
        answer += timeGap / 15;
        timeGap %= 15;
        answer += timeGap / 5;
        timeGap %= 5;
        answer += timeGap;

        return answer;
    }

    private int getTime(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
}