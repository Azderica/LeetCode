class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(freqMap.keySet());
        Collections.sort(characters, (a, b) -> freqMap.get(b) - freqMap.get(a));

        StringBuilder sb = new StringBuilder();
        for(char ch : characters) {
            int loop = freqMap.get(ch);
            for(int i = 0; i < loop; i++) sb.append(ch);
        }
        return sb.toString();
    }
}