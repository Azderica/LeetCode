class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        final int MAX = 100001;
        int[] winner = new int[MAX];
        int[] loser = new int[MAX];

        for(int[] match : matches) {
            winner[match[0]]++;
            loser[match[1]]++;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> noDefeat = new ArrayList<>();
        List<Integer> oneDefeat = new ArrayList<>();
        for(int i = 1; i < MAX; i++) {
            if(winner[i] > 0 && loser[i] == 0) noDefeat.add(i);
            else if(loser[i] == 1) oneDefeat.add(i);
        }
        result.add(noDefeat);
        result.add(oneDefeat);
        return result;
        
    }
}