class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // exception case
        if(!wordList.contains(endWord)) return 0;
        if(beginWord.equals(endWord)) return 1;
        
        // initialization
        Set<String> visited = new HashSet<>();
        Queue<Word> q = new LinkedList<>();
        
        q.add(new Word(beginWord, 1));
        visited.add(beginWord);
        
        while(!q.isEmpty()) {
            Word cur = q.poll();
            if(cur.word.equals(endWord)) {
                return cur.depth;
            }
            
            for(int i = 0; i < wordList.size(); i++) {
                if(!visited.contains(wordList.get(i)) && isAdjacent(cur.word, wordList.get(i))) {
                    q.add(new Word(wordList.get(i), cur.depth + 1));
                    visited.add(wordList.get(i));
                }
            }
        }
        
        return 0;
    }
    
    private boolean isAdjacent(String target, String cur) {
        int count = 0, n = target.length();
        if(target.length() != cur.length()) return false;
        for(int i = 0; i < n; i++) {
            if(target.charAt(i) != cur.charAt(i)) {
                count++;
            }
            if(count >= 2) {
                return false;
            }
        }
        if(count == 1)
            return true;
        return false;
    }
    
    class Word {
        String word;
        int depth;
        Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
}