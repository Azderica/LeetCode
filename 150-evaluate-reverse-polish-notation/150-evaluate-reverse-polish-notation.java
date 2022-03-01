class Solution {
    public int evalRPN(String[] tokens) {

        String op = "+*-/";
        Stack<Integer> st = new Stack<>();

        for(String token : tokens) {
            if(op.contains(token)) {
                int val1 = st.pop();
                int val2 = st.pop();
                switch (token) {
                    case "+":
                        st.add(val2 + val1);
                        break;
                    case "-":
                        st.add(val2 - val1);
                        break;
                    case "*":
                        st.add(val2 * val1);
                        break;
                    case "/":
                        st.add(val2 / val1);
                        break;
                    default:
                        System.err.println("This is not op");
                }
            } else {
                // this is numeric
                st.add(Integer.valueOf(token));
            }
        }

        if(st.size() != 1) {
            System.err.println("Answer is wrong.");
        }
        return st.pop();
    }
}