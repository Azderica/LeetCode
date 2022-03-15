class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0, left = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                left++;
                balance++;
            } else if(ch == ')') {
                if(balance == 0) continue;
                balance--;
            }
            sb.append(ch);
        }

        // remove '('
        StringBuilder result = new StringBuilder();
        int right = left - balance;
        for(char ch : sb.toString().toCharArray()) {
            if(ch == '(') {
                right--;
                if(right < 0) continue;
            }
            result.append(ch);
        }

        return result.toString();
    }
}