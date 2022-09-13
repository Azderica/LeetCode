class Solution {
    public int numberOfSteps(int num) {
        int steps = 0, number = num;
        while (number > 0) {
            if(number % 2 == 0) {
                number /= 2;
            } else {
                number -= 1;
            }
            steps++;
        }
        return steps;
    }
}