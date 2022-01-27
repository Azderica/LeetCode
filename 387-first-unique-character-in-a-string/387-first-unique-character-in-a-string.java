class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> characterMap = new LinkedHashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(characterMap.containsKey(ch)) {
                characterMap.put(ch, characterMap.get(ch) + 1);
            } else {
                characterMap.put(ch, 1);
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(characterMap.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}