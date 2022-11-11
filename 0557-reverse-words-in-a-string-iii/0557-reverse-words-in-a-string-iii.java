class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(int i = 0; i < words.length; i++) {
            StringBuilder tmp = new StringBuilder(words[i]);
            sb.append(tmp.reverse().toString());
            if(i != words.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }
}