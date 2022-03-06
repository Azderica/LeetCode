class Solution {
    public String decodeString(String s) {
        Stack<Integer> countSt = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countSt.add(k);
                stringStack.add(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                for(int i = countSt.pop(); i > 0; i--) {
                    decodedString.append(cur);
                }
                cur = decodedString;
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }
}