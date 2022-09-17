class TrieNode {
    public int wordEnding = -1;
    public Map<Character, TrieNode> next = new HashMap<>();
    public List<Integer> palindromePrefixRemaining = new ArrayList<>();
}

public class Solution {
    public boolean hasPalindromeRemaining(String s, int i) {
        int p1 = i, p2 = s.length() - 1;
        while(p1 < p2) {
            if(s.charAt(p1) != s.charAt(p2)) return false;
            p1++;   p2--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode trie = new TrieNode();

        for(int id = 0; id < words.length; id++) {
            String word = words[id];
            String reversedWord = new StringBuilder(word).reverse().toString();
            TrieNode currentTrieLevel = trie;
            for(int j = 0; j < word.length(); j++) {
                if(hasPalindromeRemaining(reversedWord, j)){
                    currentTrieLevel.palindromePrefixRemaining.add(id);
                }
                Character c = reversedWord.charAt(j);
                if(!currentTrieLevel.next.containsKey(c)) {
                    currentTrieLevel.next.put(c, new TrieNode());
                }
                currentTrieLevel = currentTrieLevel.next.get(c);
            }
            currentTrieLevel.wordEnding = id;
        }

        List<List<Integer>> pairs = new ArrayList<>();
        for(int id = 0; id < words.length; id++) {
            String word = words[id];
            TrieNode currentTrieLevel = trie;
            for(int j = 0; j < word.length(); j++) {
                if(currentTrieLevel.wordEnding != -1 && hasPalindromeRemaining(word, j)) {
                    pairs.add(Arrays.asList(id, currentTrieLevel.wordEnding));
                }
                Character c = word.charAt(j);
                currentTrieLevel = currentTrieLevel.next.get(c);
                if(currentTrieLevel == null) break;
            }
            if(currentTrieLevel == null) continue;
            if(currentTrieLevel.wordEnding != -1 && currentTrieLevel.wordEnding != id) {
                pairs.add(Arrays.asList(id, currentTrieLevel.wordEnding));
            }
            for(int other : currentTrieLevel.palindromePrefixRemaining) {
                pairs.add(Arrays.asList(id, other));
            }
        }

        return pairs;
    }
}