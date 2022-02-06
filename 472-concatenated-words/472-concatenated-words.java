class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean wordEnd;
        
        void addWord(String word, int pos) {
            if(pos == word.length()) wordEnd = true;
            else {
                int childIndex = word.charAt(pos) - 'a';
                if(children[childIndex] == null) {
                    children[childIndex] = new TrieNode();
                }   
                children[childIndex].addWord(word, pos + 1);
            }
        }
    }
    
    private TrieNode root;
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        
        Arrays.sort(words, Comparator.comparingInt(String::length));
        root = new TrieNode();
        for(String word : words) {
            if(findWord(word)) result.add(word);
            root.addWord(word, 0);
        }
        
        return result;
    }
    
    private boolean findWord(String word) {
        int n = word.length();
        if(n == 0) return false;
        boolean[] suffixFound = new boolean[n];
        for(int i = n - 1; i >= 0; i--) {
            int pos = i;
            TrieNode node = root;
            while(node != null) {
                if(node.wordEnd) {
                    if(pos == n || suffixFound[pos]) {
                        suffixFound[i] = true;
                        break;
                    }
                }
                if(pos == n) break;
                int childIndex = word.charAt(pos) - 'a';
                node = node.children[childIndex];
                pos++;
            }
        }
        return suffixFound[0];
    }
}