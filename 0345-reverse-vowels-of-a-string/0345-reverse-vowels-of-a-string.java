class Solution {
    public String reverseVowels(String s) {
        char[] words = s.toCharArray();
        String vowel = "aeiouAEIOU";
        List<Character> vowels = new ArrayList<>();

        for(char ch : words) {
            if(vowel.indexOf((ch + "")) >= 0) {
                vowels.add(ch);
            }
        }
        Collections.reverse(vowels);

        int index = 0;
        for(int i = 0; i < words.length; i++) {
            if(vowel.indexOf((words[i] + "")) >= 0) {
                words[i] = vowels.get(index++);
            }
        }

        return new String(words);
    }
}