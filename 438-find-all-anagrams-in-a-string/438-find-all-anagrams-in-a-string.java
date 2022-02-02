class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        int[] result = new int[26];
        int[] matching = new int[26];
        List<Integer> answer = new ArrayList<>();
        
        if(s.length() < p.length()) {
            return new ArrayList<>();
        }
        
        for(char ch : p.toCharArray()) {
            result[(ch - 'a')]++;
        }
        for(int i = 0; i < n; i++) {
            matching[s.charAt(i) - 'a']++;
        }
        if(isAnagram(matching, result)) answer.add(0);
        for(int i = 0; i + n < s.length(); i++) {
            matching[s.charAt(i) - 'a']--;
            matching[s.charAt(i + n) - 'a']++;
            if(isAnagram(matching, result)) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
    
    private boolean isAnagram(int[] matching, int[] result) {
        for(int i = 0; i < 26; i++) {
            if(matching[i] != result[i])
                return false;
        }
        return true;
    }
}