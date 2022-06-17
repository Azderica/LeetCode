class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double result = 0, prev = 0;
        for(int[] bracket : brackets) {
            result += Math.max(0.0, (-prev + Math.min(income, bracket[0])) * bracket[1] / 100);
            prev = bracket[0];
        }
        return result;
    }
}