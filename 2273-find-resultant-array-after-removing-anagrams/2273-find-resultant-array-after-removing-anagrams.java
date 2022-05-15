class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> anagrams = new ArrayList<>();
        anagrams.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            if(!isAnagram(words[i - 1], words[i])) {
                anagrams.add(words[i]);
            }
        }
        return anagrams;
    }

    private boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) return false;
        int[] alphabet = new int[26];
        for(int i = 0; i < a.length(); i++) {
            alphabet[a.charAt(i) - 'a'] ++;
            alphabet[b.charAt(i) - 'a'] --;
        }
        int sum = 0;
        for(int val: alphabet) {
            sum += Math.abs(val);
        }
        return sum == 0;
    }
}