class Solution {
    int group[] = new int[26];

    private int find(int x) {
        if(group[x] == x) return x;
        return group[x] = find(group[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) group[y] = x;
        else if(x > y) group[x] = y;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int len = Math.min(s1.length(), s2.length());
        for(int i = 0; i < 26; i++) group[i] = i;
        for(int i = 0; i < len; i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : baseStr.toCharArray()) {
            sb.append((char)(find(ch - 'a') + 'a'));
        }
        return sb.toString();
    }
}