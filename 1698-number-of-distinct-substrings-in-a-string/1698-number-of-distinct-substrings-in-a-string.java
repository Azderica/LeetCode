class Solution {
    public int countDistinct(String s) {
        Set<String> subStrSet = new LinkedHashSet<>();

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= s.length() - i; j++) {
                subStrSet.add(s.substring(j, j + i));
            }
        }

        return subStrSet.size();
    }
}