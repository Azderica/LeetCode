class Solution {
    public String minimizeResult(String expression) {
        String left = expression.split("\\+")[0];
        String right = expression.split("\\+")[1];

        String result = "(" + expression + ")";
        int minVal = Integer.valueOf(left) + Integer.valueOf(right);

        for (int i = 0; i < left.length(); i++) {
            for (int j = 1; j <= right.length(); j++) {
                int leftMul = 1, leftSum, rightSum, rightMul = 1;
                if(i != 0)
                    leftMul = Integer.valueOf(left.substring(0, i));
                leftSum = Integer.valueOf(left.substring(i));
                rightSum = Integer.valueOf(right.substring(0, j));
                if(j != right.length())
                    rightMul = Integer.valueOf(right.substring(j));

                int cur = leftMul * (leftSum + rightSum) * rightMul;
                if (cur < minVal) {
                    minVal = cur;
                    result = "";
                    if(i != 0) result += leftMul;
                    result += "(" + leftSum + "+" + rightSum + ")";
                    if(j != right.length()) result += rightMul;
                }
            }
        }

        return result;
        
    }
}