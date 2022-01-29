class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> result) {
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null) 
            return;
        p = p.next[c - 'a'];
        if(p.word != null) {    // find one
            result.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';      // avoid duplicate
        if(i > 0) dfs(board, i - 1, j, p, result);
        if(j > 0) dfs(board, i, j - 1, p, result);
        if(i < board.length - 1) dfs(board, i + 1, j, p, result);
        if(j < board[0].length - 1) dfs(board, i, j + 1, p, result);
        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode p = root;
            for(char c : word.toCharArray()) {
                int i = c - 'a';
                if(p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}